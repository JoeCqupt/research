package me.research;

import java.util.HashSet;
import java.util.Set;

public class LC73 {

    static class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> is = new HashSet<>();
            Set<Integer> js = new HashSet<>();

            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        is.add(i);
                        js.add(j);
                    }
                }
            }

            for (int i : is) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }

            for (int j : js) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
