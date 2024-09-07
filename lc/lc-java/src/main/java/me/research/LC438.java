package me.research;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s.length() < p.length()) {
                return res;
            }

            int[] pArrs = new int[26];
            for (Character c : p.toCharArray()) {
                pArrs[c - 'a'] = pArrs[c - 'a'] + 1;
            }

            int[] tArrs = new int[26];
            int pl = p.length();
            char[] chars = s.toCharArray();
            int left = 0;
            int right = pl - 1;
            for (int i = 0; i < pl; i++) {
                Character c = chars[i];
                tArrs[c - 'a'] = tArrs[c - 'a'] + 1;
            }
            while (right < chars.length) {
                boolean b = Arrays.equals(tArrs, pArrs);
                if (b) {
                    res.add(left);
                }

                Character leftC = chars[left];
                tArrs[leftC - 'a'] = tArrs[leftC - 'a'] - 1;
                left++;

                if (right == chars.length - 1) {
                    break;
                }
                right++;
                Character rightC = chars[right];
                tArrs[rightC - 'a'] = tArrs[rightC - 'a'] + 1;
            }

            return res;

        }


    }
}
