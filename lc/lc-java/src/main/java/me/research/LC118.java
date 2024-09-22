package me.research;

import java.util.ArrayList;
import java.util.List;

public class LC118 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(5);
    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> list = new ArrayList<>(i + 1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j ==  i ) {
                        list.add(1);
                    } else {
                        list.add(resList.get(i - 1).get(j - 1) + resList.get(i - 1).get(j));
                    }
                }
                resList.add(list);
            }

            return resList;
        }
    }
}
