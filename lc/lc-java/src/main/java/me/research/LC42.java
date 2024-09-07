package me.research;

public class LC42 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int trap = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        int trap = solution.trap(new int[]{8, 5, 4, 1, 8, 9, 3, 0, 0});

        System.out.println(trap);
    }

    // 我的答案 笑死 打败5%的同学
//    static class Solution {
//        public int trap(int[] height) {
//            int idx = max(height, 0, height.length - 1);
//
//            int leftValue = 0;
//            int rightValue = 0;
//            if (idx - 1 >= 0) {
//                leftValue = trap(height, 0, idx - 1, idx);
//            }
//            if (idx + 1 < height.length) {
//                rightValue = trap(height, idx + 1, height.length - 1, idx);
//            }
//
//            return leftValue + rightValue;
//        }
//
//        private int max(int[] height, int left, int right) {
//            int maxHeight = 0;
//            int idx = 0;
//            for (int i = left; i <= right; i++) {
//                if (height[i] >= maxHeight) {
//                    maxHeight = height[i];
//                    idx = i;
//                }
//            }
//            return idx;
//        }
//
//        private int trap(int[] height, int left, int right, int boundIdx) {
//            if (left== right){
//                return 0;
//            }
//
//            int idx = max(height, left, right);
//            if (boundIdx > idx) {
//                int sum = (boundIdx - idx - 1) * height[idx] - sum(height, idx, boundIdx);
//                if (idx - 1 >= 0) {
//                    return sum +
//                            trap(height, 0, idx - 1, idx);
//                }
//                return sum;
//            } else {
//                int sum = (idx - boundIdx - 1) * height[idx] - sum(height, boundIdx, idx);
//                if (idx + 1 < height.length) {
//                    return sum +
//                            trap(height, idx + 1, height.length - 1, idx);
//                }
//                return sum;
//            }
//
//        }
//
//        private int sum(int[] height, int left, int right) {
//            int sum = 0;
//            for (int i = left + 1; i < right; i++) {
//                sum += height[i];
//            }
//            return sum;
//        }
//
//
//    }
    static class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n <=2){
                return 0;
            }
            int[] leftMax = new int[n];
            leftMax[0] = height[0];
            for (int i = 1; i< n; i++){
                leftMax[i] =  Math.max(height[i], height[i-1]);
            }
            int[] rightMax = new int[n];
            rightMax[n-1] = height[n-1];
            for (int i = n-2; i>=0; i--){
                rightMax[i] = Math.max(height[i], height[i+1]);
            }
            int result = 0;
            for (int i = 0; i < n; i++){
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return result;
        }
    }

}
