package com.git.wuqf;

public class Solution21 {
    public static void main(String[] args) {
        ListNode l14 = new ListNode(4);
        ListNode l12 = new ListNode(3, l14);
        ListNode l11 = new ListNode(1, l12);
        ListNode l24 = new ListNode(4);
        ListNode l23 = new ListNode(3, l24);
        ListNode l21 = new ListNode(1, l23);
        Solution21 s = new Solution21();
        ListNode listNode = s.mergeTwoLists(l11, l21);
        System.out.println("xx");

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return prehead.next;

    }

}
