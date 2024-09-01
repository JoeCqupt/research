package me.research;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC49 {

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String s = new String(charArray);
                if (!map.containsKey(s)) {
                    map.put(s, new ArrayList<>());
                }
                map.get(s).add(str);
            }

            return map.values().stream().collect(Collectors.toList());
        }
    }
}
