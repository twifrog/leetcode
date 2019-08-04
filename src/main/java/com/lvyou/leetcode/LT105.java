package com.lvyou.leetcode;

public class LT105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preoder,int preStart,int preEnd,int[] inorder, int inStart, int inEnd){
        if (preEnd < preStart || inEnd < inStart || (preEnd-preStart) != (inEnd-inStart)){
            return null;
        }
        TreeNode root = new TreeNode(preoder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == preoder[preStart]) {
                index = i;
                break;
            }
        }

        root.left = buildTree(preoder,preStart+1,preStart+index-inStart,inorder,inStart,index-1);
        root.right = buildTree(preoder,preStart+index-inStart+1,preEnd,inorder,index+1,inEnd);
        return root;
    }
}
