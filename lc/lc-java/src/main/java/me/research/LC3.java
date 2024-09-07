package me.research;

import java.util.HashSet;
import java.util.Set;

public class LC3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> sets = new HashSet<>();
            int res = 0;

            int left = 0;
            int right = 0;
            char[] chars = s.toCharArray();
            while (right < chars.length) {
                char c = chars[right];
                if (!sets.contains(c)) {
                    sets.add(c);
                    right++;
                    res = Math.max(res, sets.size());
                } else {
                    while (sets.contains(c)) {
                        sets.remove(chars[left]);
                        left++;
                    }
                    right++;
                    sets.add(c);
                }

            }

            return res;
        }
    }

}
