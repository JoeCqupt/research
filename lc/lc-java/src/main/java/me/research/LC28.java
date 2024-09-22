package me.research;

public class LC28 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.strStr("aabaaabaaac", "aabaaac");
        System.out.println(i);
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            int[] next = buildNext(needle);

            for (int i = 0, j = 0, length = 0; i < haystack.length(); ) {
                while (haystack.charAt(i) == needle.charAt(j)) {
                    length++;
                    if (length == needle.length()) {
                        return i - length + 1;
                    }

                    i++;
                    j++;

                    if (i >= haystack.length()
                            || j >= needle.length()) {
                        return -1;
                    }
                }

                if (j >= 1) {
                    j = next[j - 1];
                } else {
                    i++;
                }

                length = j;
            }

            return -1;
        }

        private int[] buildNext(String needle) {
            int[] next = new int[needle.length()];
            next[0] = 0;
            int recur = 0;
            for (int cur = 1; cur < needle.length(); cur++) {
                while (recur > 0 && needle.charAt(cur) != needle.charAt(recur)) {
                    recur = next[recur - 1];
                }
                if (needle.charAt(cur) == needle.charAt(recur)) {
                    recur++;
                }
                next[cur] = recur;
            }

            return next;
        }
    }
}
