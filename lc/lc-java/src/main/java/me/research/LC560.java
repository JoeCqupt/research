package me.research;

import java.util.HashMap;
import java.util.Map;

public class LC560 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(i);
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int res = 0;
            int n = nums.length;
            int[] sumArr = new int[n];
            sumArr[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sumArr[i] = nums[i] + sumArr[i - 1];
            }


            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < n; i++) {
                int value = sumArr[i];
                int targt = value - k;
                if (map.containsKey(targt)) {
                    res += map.get(targt);
                }
                map.put(sumArr[i], map.getOrDefault(sumArr[i], 0) + 1);
            }
            return res;
        }
    }

}
