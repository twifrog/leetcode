package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 19:57
 */
public class Main21 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode ans = norepeatList(head);
        System.out.println("finish");
    }
    public static ListNode norepeatList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head;
        while (start != null && start.next != null) {
            if (start.val == start.next.val) {
                start.next = start.next.next;
            } else {
                start = start.next;
            }
        }
        return head;

    }
}
