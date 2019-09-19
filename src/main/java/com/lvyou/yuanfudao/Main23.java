package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 20:15
 */
public class Main23 {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(5);
        node.right.right =new TreeNode(8);
        TwoWayListNode ans = rebuild(node);
        System.out.println(ans);

    }


    public static TwoWayListNode rebuild(TreeNode node) {

        if (node == null) {return null;}

        TwoWayListNode mid = new TwoWayListNode(node.val);
        TwoWayListNode left = rebuild(node.left);

        TwoWayListNode current = left;
        if (left != null) {
            while (current != null && current.next != null) {
                current = current.next;
            }
            current.next = mid;
            mid.prev = current;
        }

        TwoWayListNode right = rebuild(node.right);
        if (right != null) {
            mid.next = right;
            right.prev = mid;
        }
        return left == null ? mid : left;
    }
}
