package com.git.wuqf;

public class Solution22 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        Solution22 solution22 = new Solution22();
        ListNode kthFromEnd = solution22.getKthFromEnd(l1, 4);
        System.out.println("x");
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return null;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
