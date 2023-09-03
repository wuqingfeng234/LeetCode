package com.git.wuqf;

import java.util.Stack;

public class Solution234 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l5;
        //l4.next = l5;
        l5.next = l6;
        Solution234 solution234 = new Solution234();
        boolean palindrome = solution234.isPalindrome(l1);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode current = head;
        while (current != null) {
            stack.add(current);
            current = current.next;
        }
        current = head;
        while (current != null) {
            ListNode reverse = stack.pop();
            if (current.val != reverse.val) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
}
