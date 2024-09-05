package me.research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                Integer target = -nums[i];
                List<List<Integer>> twoSums = twoSum(nums, target, i + 1);
                for (List<Integer> l : twoSums) {
                    l.add(nums[i]);
                    res.add(l);
                }
            }

            List<List<Integer>> filterRes = new ArrayList<>();
            Set<String> sets = new HashSet<>();
            for (List<Integer> list : res) {
                Collections.sort(list);
                String str = list.toString();
                if (!sets.contains(str)) {
                    sets.add(str);
                    filterRes.add(list);
                }
            }

            return filterRes;
        }

        private List<List<Integer>> twoSum(int[] nums, Integer target, int startIdx) {
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = startIdx; i < nums.length; i++) {
                map.put(target - nums[i], i);
            }

            for (int i = startIdx; i < nums.length; i++) {
                int v = nums[i];
                if (map.containsKey(v) && i != map.get(v)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[map.get(v)]);
                    map.remove(nums[map.get(v)]);
                    res.add(list);
                }
            }
            return res;
        }
    }
}
