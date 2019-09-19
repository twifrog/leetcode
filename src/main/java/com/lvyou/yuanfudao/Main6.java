package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 17:32
 */
public class Main6 {

    class TreeNode{

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        int[] nums = {7,1,9,2,4,8};
        Main6 main6 = new Main6();
        TreeNode ans = main6.rebuild(nums);

        System.out.println(ans);
    }

    private TreeNode rebuild (int[] nums) {

        TreeNode root = new TreeNode(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            insert(nums[i],root);
        }
        return root;
    }

    private void insert(int i, TreeNode root) {

        if (i < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(i);
                return;
            } else {
                insert(i,root.left);
            }
        } else if (i > root.val){
            if (root.right == null) {
                root.right = new TreeNode(i);
                return;
            } else {
                insert(i,root.right);
            }
        }
    }
}
