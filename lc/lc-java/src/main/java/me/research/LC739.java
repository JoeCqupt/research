package me.research;

import java.util.Arrays;
import java.util.LinkedList;

public class LC739 {
    public static void main(String[] args) {
        LC739 lc = new LC739();
        int[] res = lc.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(res));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈
        LinkedList<Item> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int value = temperatures[i];
            Item item = new Item(i, value);
            while (stack.peek() != null && stack.peek().value < value) {
                Item pop = stack.pop();
                int res = (i - pop.idx);
                result[pop.idx] = res;
            }
            stack.addFirst(item);
        }
        while (!stack.isEmpty()) {
            Item pop = stack.pop();
            result[pop.idx] = 0;
        }

        return result;
    }

    static class Item {
        int idx;
        int value;

        public Item(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
