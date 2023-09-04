package com.git.wuqf;

import java.util.Stack;

public class SolutionO06 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        SolutionO06 solutionO06=new SolutionO06();
        int[] ints = solutionO06.reversePrint(l1);
        System.out.println("x");
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack();
        ListNode cur = head;
        while (cur != null) {
            s.add(cur.val);
            cur = cur.next;
        }
        int size = s.size();
        int[] ans = new int[s.size()];
        for (int i = 0; i < size; i++) {
            ans[i] = s.pop();
        }
        return ans;
    }
}
