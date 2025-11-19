package hot100;

import java.util.PriorityQueue;

public class t148sortList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
    static class Solution {
        public ListNode sortList(ListNode head) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            ListNode curr = head;
            while(curr != null) {
                pq.add(curr);
                curr = curr.next;
            }
            ListNode dummy = new ListNode(-1);
            curr = dummy;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                curr.next = node;
                curr = curr.next;
                curr.next = null;
            }
            return dummy.next;
        }
    }
}
