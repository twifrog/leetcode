package com.lvyou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: VernLv
 * @Data: Create in 17:04 2019/8/21
 */
public class LT116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        if (root == null || root.left == null){
            return root;
        }
        root.left.next = root.right;
        if (root.right != null ) {
            if(root.next != null){
                root.right.next = root.next.left;
            } else{
                root.right.next = null;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

}
