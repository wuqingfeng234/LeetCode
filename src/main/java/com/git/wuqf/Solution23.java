package com.git.wuqf;

import java.util.List;

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for (int i = 0; i < lists.length; i++) {
            listNode = mergeTwoLists(listNode, lists[i]);
        }
        return listNode;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        ListNode acur = a;
        ListNode bcur = b;
        while (acur != null && bcur != null) {
            if (acur.val <= bcur.val) {
                cur.next = acur;
                acur = acur.next;
            } else {
                cur.next = bcur;
                bcur = bcur.next;
            }
            cur = cur.next;
        }
        cur.next = acur == null ? bcur : acur;
        return preHead.next;
    }
}
