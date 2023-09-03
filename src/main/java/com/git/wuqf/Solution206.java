package com.git.wuqf;

public class Solution206 {
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution206 solution206 = new Solution206();
        ListNode listNode = solution206.reverseList(l1);
        System.out.println("x");
    }

    public ListNode reverseList(ListNode head) {
        return rec(head, null);
    }

    private ListNode rec(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        }
        ListNode newHead = rec(head.next, head);
        head.next = pre;
        return newHead;
    }
}
