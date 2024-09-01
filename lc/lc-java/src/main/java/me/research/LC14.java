package me.research;

public class LC14 {

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuffer sb = new StringBuffer();

            int idx = 0;
            while (true) {
                char temp = 0;
                for (int i = 0; i < strs.length; i++) {
                    String str = strs[i];
                    if (idx >= str.length()) {
                        return sb.toString();
                    }

                    if (i == 0) {
                        temp = str.charAt(idx);
                    } else {
                        if (str.charAt(idx) != temp) {
                            return sb.toString();
                        }
                    }
                }
                sb.append(temp);
                idx++;
            }
        }
    }
}
