package me.research;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        int[][] result = solution.merge(intervals);

        System.out.println(Arrays.deepToString(result));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    return arr1[0] - arr2[0];
                }
            });

            List<int[]> result = new ArrayList<>();

            int[] interval = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] tmp = intervals[i];
                boolean crossed = !(interval[1] < tmp[0]);
                if (!crossed) {
                    result.add(interval);
                    interval = tmp;
                } else {
                    interval = new int[]{interval[0], tmp[1] > interval[1] ? tmp[1] : interval[1]};
                }
            }
            result.add(interval);

            return result.toArray(new int[][]{});
        }

    }
}
