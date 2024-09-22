package me.research;

public class LC209 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
  static   class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;
            int sum = 0;

            int res = 0;

            for (; right < nums.length; ) {
                if (nums[right] >= target) {
                    return 1;
                }

                sum += nums[right];
                if (sum >= target) {
                    while (sum >= target && left <= right) {
                        if (res == 0) {
                            res = right - left + 1;
                        } else {
                            res = Math.min(res, right - left + 1);
                        }

                        sum -= nums[left];
                        left++;
                    }
                    right++;
                } else {
                    right++;
                }
            }

            return res;
        }
    }
}
