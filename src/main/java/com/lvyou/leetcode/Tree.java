package com.lvyou.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: VernLv
 * @Data: Create in 10:20 2019/8/13
 */
public class Tree {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static List<Integer> preorderTravesal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || root != null) {
            while (node != null) {
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop().right;
        }
        return ans;
    }

    //LT94有其他的
}
