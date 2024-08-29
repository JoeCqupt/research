package me.research;

public class LC48 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        );
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;

            // 水平翻转
            int mid = n / 2;
            for (int i = 0; i < mid; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - i][j];
                    matrix[n - 1 - i][j] = temp;
                }
            }

            // 对角线翻转
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
