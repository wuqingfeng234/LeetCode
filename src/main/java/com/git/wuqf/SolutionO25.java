package com.git.wuqf;

public class SolutionO25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l1.next = l3;
        l3.next = l5;
        //------------------------------------//

        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        l2.next = l4;
        l4.next = l6;
        SolutionO25 solutionO25 = new SolutionO25();
        ListNode listNode = solutionO25.mergeTwoLists(l1, l2);
        System.out.println("x");
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

}
