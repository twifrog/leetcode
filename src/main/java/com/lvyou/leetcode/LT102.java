package com.lvyou.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LT102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> level = new LinkedList<Integer>();
        int currentlevel = 1;
        int nextlevel = 0;
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            level.add(current.val);
            currentlevel--;
            if (current.left != null){
                queue.add(current.left);
                nextlevel++;
            }
            if (current.right != null){
                queue.add(current.right);
                nextlevel++;
            }
            if (currentlevel == 0){
                currentlevel = nextlevel;
                ans.add(new LinkedList<Integer>(level));
                level.clear();
                nextlevel = 0;
            }
        }
        return ans;
    }
}
