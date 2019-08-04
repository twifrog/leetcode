package com.lvyou.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LT94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}
