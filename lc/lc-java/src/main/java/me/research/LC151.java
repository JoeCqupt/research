package me.research;

public class LC151 {

    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();

            char[] chars = s.toCharArray();
            int length = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                char aChar = chars[i];
                if (aChar != ' ') {
                    length++;
                } else if (aChar == ' ') {
                    if (length != 0) {
                        if (sb.length()!=0){
                            sb.append(' ');
                        }
                        for (int x = 0; x < length; x++) {
                            sb.append(chars[i + 1 + x]);
                        }
                        length = 0;
                    }
                }
            }

            if (length != 0) {
                if (sb.length()!=0){
                    sb.append(' ');
                }
                for (int x = 0; x < length; x++) {
                    sb.append(chars[x]);
                }
            }


            return sb.toString();
        }
    }

}
