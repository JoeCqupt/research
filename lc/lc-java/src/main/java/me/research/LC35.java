package me.research;

public class LC35 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.searchInsert(new int[]{1, 3, }, 2);
        System.out.println(i);
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;


            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                }
                if (target < nums[mid]) {
                    right = mid - 1;
                }
                if (target > nums[mid]) {
                    left = mid + 1;
                }
            }

            if (target == nums[left]) {
                return left;
            }
            if (target < nums[left]) {
                return left;
            }
            if (target > nums[left]) {
                return left + 1;
            }

            // should not reach here
            return  -1;
        }

    }
}
