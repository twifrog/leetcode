package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 18:10
 */
public class Main17 {



    public static void main(String[] args) {
        Main17 main17 = new Main17();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode ans = main17.reverseI(head);
        System.out.println("finish");
    }
    public ListNode reverseR(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;

        ListNode newhead = reverseR(next);
        head.next = null;
        next.next = head;
        return newhead;
    }

    public ListNode reverseI(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        ListNode pre = null;
        while (node != null) {

            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;

        }
        return pre;
    }
}
