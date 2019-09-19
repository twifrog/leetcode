package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 21:03
 */
public class Main36 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode ans = sort(head);
    }

    public static ListNode sort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode edge = head;
        ListNode current = head;
        ListNode pre = edge;
        while (current != null) {
            pre = edge;
            if (current.val % 2 == 1) {
                swap(current,edge);
                edge = edge.next;
                current = current.next;
            } else {
                current = current.next;
            }
        }
        //将pre的左右分别排序就行了
        return null;
    }
    public static void swap(ListNode l1, ListNode l2) {
        int temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;
    }
}
