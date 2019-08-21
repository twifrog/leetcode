package com.lvyou.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LT114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    private List<TreeNode> list = new LinkedList<>();

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.left);
        flatten1(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }


    public void flatten(TreeNode root) {
        preOrder(root);
        for (int i = 0; i < list.size() - 1; i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }

    }

    private void preOrder(TreeNode root) {
        if (root == null){
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
