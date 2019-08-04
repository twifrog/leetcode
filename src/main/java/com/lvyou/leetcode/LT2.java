package com.lvyou.leetcode;

import java.util.List;

public class LT2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ans = new ListNode(0);
        ListNode tail = ans, current1 = l1, current2 = l2;

        int set = 0;

        while (current1 != null && current2 != null) {
            int val = current1.val + current2.val + set;
            if (val > 0) {
                val = val % 10;
                set = 1;
            } else {
                set = 0;
            }
            ListNode temp = new ListNode(val);
            tail.next = temp;
            tail = tail.next;
            current1 = current1.next;
            current2 = current2.next;
            if( current1 == null  && current2 == null){
                break;
            }
            if (current1 == null) {
                current1 = new ListNode(0);
            }
            if (current2 == null) {
                current2 = new ListNode(0);
            }
        }
        if( set != 0) {
            tail.next = new ListNode(set);
        }
        return ans.next;
    }
}
