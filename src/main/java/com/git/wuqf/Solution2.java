package com.git.wuqf;

public class Solution2 {
    public static void main(String[] args) {

        ListNode l2 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l2.next = l4;
        l4.next = l3;
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l41 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        l5.next = l6;
        l6.next = l41;
        l41.next = l9;
        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.addTwoNumbers(l2, l5);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
        }
        return head.next;
    }
}
