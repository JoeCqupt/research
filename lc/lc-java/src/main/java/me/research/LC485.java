package me.research;

public class LC485 {

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int left = 0;
            int right = 0;

            int res = 0;

            for (; right < nums.length; right++) {
                if (nums[right] == 1) {
                    res = Math.max(res, right - left + 1);
                } else {
                    left = right + 1;
                }
            }

            return res;
        }
    }

}
