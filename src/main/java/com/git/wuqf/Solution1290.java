package com.git.wuqf;

public class Solution1290 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        Solution1290 solution1290 = new Solution1290();
        int decimalValue = solution1290.getDecimalValue(l1);
        System.out.println("x");
    }

    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            ans = ans * 2 + cur.val;
            cur = cur.next;
        }
        return ans;
    }
}
