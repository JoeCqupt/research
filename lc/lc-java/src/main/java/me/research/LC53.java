package me.research;

import java.util.Arrays;

public class LC53 {

//    class Solution {
//        public int maxSubArray(int[] nums) {
//            int n = nums.length;
//
//            int[] sums = new int[n];
//            sums[0] = nums[0];
//
//            for (int i = 1; i < n; i++) {
//                sums[i] = nums[i] + sums[i - 1];
//            }
//
//            int res = Arrays.stream(sums).max().getAsInt();
//
//            for (int left = 0; left < n; left++) {
//                for (int right = left + 1; right < n; right++) {
//                    int tempSum = sums[right] - sums[left];
//                    res = Math.max(tempSum, res);
//                }
//            }
//            return res;
//        }
//    }


    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0;
            int res = nums[0];

            for (int i : nums){
                pre = Math.max(i, pre + i);
                res = Math.max(pre, res);
            }

            return res;
        }
    }
}
