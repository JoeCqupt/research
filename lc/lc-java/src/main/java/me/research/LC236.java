package me.research;

public class LC236 {


    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);

            return ans;
        }

        private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return false;
            }
            if (node.val == p.val || node.val == q.val) {

                boolean lf = dfs(node.left, p, q);
                boolean rf = dfs(node.right, p, q);

                if ((lf || rf) && ans == null) {
                    ans = node;
                }

                return true;
            } else {


                boolean lf = dfs(node.left, p, q);
                boolean rf = dfs(node.right, p, q);

                if (lf && rf && ans == null) {
                    ans = node;
                }

                return lf || rf;
            }
        }
    }
}
