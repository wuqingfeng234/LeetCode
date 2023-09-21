package com.git.wuqf;

public class Solution19 {
    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        l2.next=l3;
        Solution19 solution19 = new Solution19();
        solution19.removeNthFromEnd(l2, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = preHead;
        ListNode slow = preHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while ((fast != null) && (fast.next != null)) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return preHead.next;
    }
}
