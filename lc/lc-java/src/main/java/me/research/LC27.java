package me.research;

public class LC27 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = 0;
            for (; right < nums.length; right++) {
                if (nums[right] != val){
                    if (right -left > 0){
                        nums[left] = nums[right];
                    }
                    left++;
                }
            }

            return left;
        }
    }

}
