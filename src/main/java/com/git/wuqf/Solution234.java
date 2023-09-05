package com.git.wuqf;

import javax.swing.*;
import java.util.Stack;

public class Solution234 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        Solution234 solution234 = new Solution234();
        boolean palindrome = solution234.isPalindrome(l1);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            ListNode stackNode = stack.pop();
            if (stackNode.val != cur.val) {
                return false;
            }
            cur=cur.next;
        }
        return true;
    }
}
