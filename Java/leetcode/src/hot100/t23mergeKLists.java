package hot100;

import java.util.PriorityQueue;

public class t23mergeKLists {
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
        ListNode() {};
        ListNode(int val) {this.val = val; }
        ListNode(int val, ListNode next) {this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode list : lists) {
                if (list != null) {
                    pq.add(list);
                }
            }
            ListNode dummy = new ListNode();
            ListNode curr = dummy;
            while(!pq.isEmpty()) {
                ListNode tmp = pq.poll();
                curr.next = tmp;
                curr = curr.next;
                if (tmp.next != null) {
                    pq.add(tmp.next);
                }
            }
            return dummy.next;
        }
    }
}
