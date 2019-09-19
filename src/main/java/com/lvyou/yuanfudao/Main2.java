package com.lvyou.yuanfudao;

/**
 * @author LeoLv
 * @date 2019/9/18 16:43
 */
public class Main2 {
    class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode tail;

    public int poll() {

        ListNode oldhead = head;

        head = head.next;

        int val = oldhead.val;

        oldhead = null;

        return val;
    }

    public void add (int val) {
        ListNode newtail = new ListNode(val);

        tail.next = newtail;

        tail = tail.next;
    }
}
