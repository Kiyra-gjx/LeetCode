package hot100;

import java.util.Objects;

public class t24swapPairs {
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
        ListNode(int val ) { this.val = val; }
        ListNode(int val, ListNode next ) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1, head.next);
            ListNode curr = head;
            ListNode prev = dummy;
            while(curr != null && curr.next != null) {
                ListNode virtual = new ListNode(0);
                virtual.next = curr.next.next;
                curr.next.next = curr;
                prev.next = curr.next;
                curr.next = virtual.next;
                prev = curr;
                curr = curr.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode result = solution.swapPairs(head);

        System.out.println(result);
    }
}
