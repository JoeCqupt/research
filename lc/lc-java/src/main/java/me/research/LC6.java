package me.research;

public class LC6 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.convert("PAYPALISHIRING", 3);
    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows <= 1) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            int l = chars.length;

            for (int i = 0; i < numRows; i++) {
                if (i == 0 || i == numRows - 1) {
                    int idx = i;
                    while (idx < l) {
                        sb.append(chars[idx]);
                        idx = idx + 2 * numRows - 2;
                    }
                }

                else {
                    int idx = i;
                    int t = 0;
                    while (idx < l) {
                        sb.append(chars[idx]);
                        if (t % 2 == 0) {
                            idx = idx + (numRows - 1 - i) + (numRows - 1 - i - 1) + 1;
                        } else {
                            idx = idx + i + i;
                        }
                        t++;
                    }
                }
            }

            return sb.toString();
        }
    }

}
