package me.research;

public class LC239 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        solution.maxSlidingWindow(new int[]{1, -1}, 1);
    }

    // 笑死打败5% 用户
//    static class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            int n = nums.length;
//            TreeMap<Integer, Integer> map = new TreeMap<>();
//
//            int[] result = new int[nums.length - k + 1];
//            int idx = 0;
//            for (int i = 0; i < n; i++) {
//                int value = nums[i];
//                if (i >= k) {
//                    if (map.get(nums[i - k]) == 1) {
//                        map.remove(nums[i - k]);
//                    } else {
//                        map.compute(nums[i - k], (key, v) -> v - 1);
//                    }
//                }
//                map.compute(value, (key, v) -> v == null ? 1 : v + 1);
//                if (i >= k - 1) {
//                    result[idx] = map.lastKey();
//                    idx++;
//                }
//            }
//
//            return result;
//        }
//    }

   static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // todo
            return null;
        }
    }


}
