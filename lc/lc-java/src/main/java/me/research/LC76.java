package me.research;

import java.util.HashMap;
import java.util.Map;

public class LC76 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.minWindow("a", "aa");
    }

   static class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> tMap = new HashMap<>();
            for (Character c : t.toCharArray()) {
                tMap.compute(c, (k, v) -> v == null ? 1 : ++v);
            }

            int rl = -1;
            int rr = -1;

            int l = 0;
            int r = 0;
            int valid = 0;
            char[] chars = s.toCharArray();
            Map<Character, Integer> sMap = new HashMap<>();
            for (; r < chars.length; r++) {
                char rChar = chars[r];
                if (tMap.containsKey(rChar)) {

                    Integer value = sMap.compute(rChar, (k, v) -> v == null ? 1 : ++v);

                    if (value == tMap.get(rChar)) {
                        valid++;
                    }
                }

                while (valid == tMap.keySet().size()) {

                    if ((rl == -1 || rr == -1) || (r - l) < (rr - rl)) {
                        rl = l;
                        rr = r;
                    }
                    char lChar = chars[l];
                    l++;
                    if (tMap.containsKey(lChar)) {
                        Integer value = sMap.compute(lChar, (k, v) -> --v);

                        if (value < tMap.get(lChar)) {
                            valid--;
                        }
                    }
                }
            }

            if (rl == -1 || rr == -1) {
                return "";
            }
            return s.substring(rl, rr + 1);
        }
    }

}
