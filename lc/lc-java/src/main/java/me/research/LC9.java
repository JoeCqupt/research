package me.research;

import java.util.ArrayList;
import java.util.List;

public class LC9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            if (x < 10) return true;
            List<Integer> list = new ArrayList<>();
            while (x != 0) {
                list.add(x % 10);
                x = x / 10;
            }

            int l = 0;
            int r = list.size()-1;

            while (l<r){
                if (list.get(l) != list.get(r)){
                    return false;
                }
                l++;
                r--;
            }

            return true;
        }
    }

}
