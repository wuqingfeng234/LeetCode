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
        //get middle
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;

        //reverse right
        ListNode pre = middle;
        ListNode cur = middle.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        ListNode rightHead = pre;
        middle.next = null;

        //compare
        boolean flag = true;
        ListNode leftCur = head;
        ListNode rightCur = rightHead;
        while (leftCur != null && rightCur != null) {
            if (leftCur.val != rightCur.val) {
                flag = false;
                break;
            }
            leftCur = leftCur.next;
            rightCur = rightCur.next;
        }
        //resume right
        ListNode rightPre = null;
        rightCur = rightHead;
        while (rightCur != middle) {
            ListNode next = rightCur.next;
            rightCur.next = rightPre;

            rightPre = rightCur;
            rightCur = next;
        }
        middle.next=rightPre;
        return flag;
    }
}
