package com.lvyou.leetcode;

/**
 * @Author: VernLv
 * @Data: Create in 17:31 2019/8/5
 */
public class LT124 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    private int max = 0;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        max = Math.max(max,root.val + left +right);
        return Math.max(left,right) + root.val;
    }
}
