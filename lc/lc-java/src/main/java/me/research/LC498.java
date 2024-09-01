package me.research;

import java.util.Arrays;

public class LC498 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] diagonalOrder = solution.findDiagonalOrder(new int[][]
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        );
        System.out.println(Arrays.toString(diagonalOrder));
    }

    static class Solution {
        int idx = 0;
        int i = 0;
        int j = 0;

        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int result[] = new int[m * n];


            while (true) {
                up(mat, result);
                if (i == m-1 && j == n-1) break;

                if (i == 0 && j != n - 1) {
                    j++;
                } else {
                    i++;
                }


                down(mat, result);
                if (i == m-1 && j == n-1) break;

                if (j == 0 && i != m - 1) {
                    i++;
                } else {
                    j++;
                }
            }

            return result;
        }

        private void down(int[][] mat, int[] result) {
            int m = mat.length;
            while (i < m && j >= 0) {
                result[idx++] = mat[i][j];

                i++;
                j--;
            }
            if (i == m || j < 0) {
                i--;
                j++;
            }
        }

        private void up(int[][] mat, int[] result) {
            int n = mat[0].length;
            while (i >= 0 && j < n) {
                result[idx++] = mat[i][j];

                i--;
                j++;
            }

            if (i < 0 || j == n) {
                i++;
                j--;
            }
        }
    }
}
