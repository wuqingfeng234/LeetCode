package com.git.wuqf;

public class Solution83 {

    public static void main(String[] args) {
        Solution83 s = new Solution83();
        ListNode n23 = new ListNode(1);
        ListNode n13 = new ListNode(1, n23);
        ListNode n2 = new ListNode(1, n13);
        ListNode n12 = new ListNode(1, n2);
        ListNode n11 = new ListNode(1, n12);
        ListNode listNode = s.deleteDuplicates(n11);
        System.out.println("x");
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
