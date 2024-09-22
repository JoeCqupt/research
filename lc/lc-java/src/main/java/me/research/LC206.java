package me.research;


public class LC206 {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverseList(null, head);
        }

        private ListNode reverseList(ListNode prev, ListNode node) {
            if (node == null) {
                return prev;
            }
            ListNode t = reverseList(node, node.next);

            node.next = prev;
            return t;
        }
    }

}
