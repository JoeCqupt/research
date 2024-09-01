package me.research;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC128 {

    // 我的答案 nlogn
//    class Solution {
//        public int longestConsecutive(int[] nums) {
//            Arrays.sort(nums);
//            Map<Integer, Integer> map = new HashMap<>();
//
//                for (int value : nums) {
//                    if (map.containsKey(value)) {
//                        map.put(value + 1, Math.max(map.getOrDefault(value + 1, 0), map.get(value) + 1));
//                    } else {
//                        map.put(value + 1, 1);
//                    }
//                }
//
//            return map.values().stream().max(Integer::compareTo).orElseGet(() -> 0);
//        }
//    }

// 标准答案 n
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            Arrays.stream(nums).forEach(set::add);
            int result = 0;
            for (int num : nums) {
                if (!set.contains(num - 1)) {
                    int cur = num;
                    int cur_length = 1;
                    while (set.contains(cur + 1)) {
                        cur++;
                        cur_length++;
                    }
                    result = Math.max(cur_length, result);
                }
            }

            return result;
        }
    }
}
