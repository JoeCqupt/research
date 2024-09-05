package me.research;

public class LC5 {

    class Solution {
        public String longestPalindrome(String s) {
            int l = s.length();
            if (l < 2) {
                return s;
            }

            boolean[][] dp = new boolean[l][l];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    dp[i][j] = true;
                }
            }

            char[] chars = s.toCharArray();
            int maxLen = 1;
            int start = 0;

            for (int len = 2; len <= l; len++) {
                for (int i = 0; i + len - 1 < l; i++) {
                    if (chars[i] != chars[i + len - 1]) {
                        dp[i][i + len - 1] = false;
                    } else {
                        if (len == 2) {
                            dp[i][i + len - 1] = true;
                        } else {
                            dp[i][i + len - 1] = dp[i + 1][i + len - 2];
                        }

                        if (dp[i][i + len - 1]) {
                            if (len > maxLen) {
                                maxLen = len;
                                start = i;
                            }
                        }
                    }
                }
            }

            return s.substring(start, start + maxLen);
        }
    }

}
