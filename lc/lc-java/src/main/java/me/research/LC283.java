package me.research;

public class LC283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            int zeroLen = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroLen++;
                } else {
                    if (zeroLen > 0) {
                        int temp = nums[i];
                        nums[i] = 0;
                        nums[i - zeroLen] = temp;
                    }
                }
            }

        }
    }

}
