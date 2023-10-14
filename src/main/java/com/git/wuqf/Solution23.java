package com.git.wuqf;


import java.util.PriorityQueue;

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(new Status(listNode.val, listNode));
            }
        }
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;
        while (!queue.isEmpty()) {
            Status poll = queue.poll();
            cur.next = poll.ptr;
            cur = cur.next;
            if (poll.ptr.next != null) {
                queue.offer(new Status(poll.ptr.next.val, poll.ptr.next));
            }
        }
        return preHead.next;
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }
}
