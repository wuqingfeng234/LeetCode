package com.git.wuqf;

import java.util.HashSet;
import java.util.Set;

public class Solution0201 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
        Solution0201 solution0201 = new Solution0201();
        ListNode listNode = solution0201.removeDuplicateNodes(l1);
        System.out.println("x");
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        while (slow != null && slow.next != null) {
            ListNode fast = slow;
            while (fast.next != null) {
                if (fast.next.val == slow.val) {
                    fast.next = fast.next.next;
                } else {
                    fast = fast.next;
                }
            }
            slow = slow.next;
        }
        return head;
    }
}
