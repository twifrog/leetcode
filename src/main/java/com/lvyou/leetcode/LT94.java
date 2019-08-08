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

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            if (node != null){
                list.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                node = node.left;
            } else {
                node = stack.pop();
            }
        }

        return list;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TreeNode node = root;
        while(!stack1.isEmpty() || node != null){
            if (node != null) {
                stack1.push(node);
                stack2.push(1);
                node = node.left;
            } else {
                if (stack2.peek() == 2) {
                    list.add(stack1.pop().val);
                    stack2.pop();
                } else {
                    node = stack1.peek().right;
                    stack2.pop();
                    stack2.push(2);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        List<Integer> list = preorderTraversal(root);
        for ( Integer i : list){
            System.out.println(i);
        }
    }
}
