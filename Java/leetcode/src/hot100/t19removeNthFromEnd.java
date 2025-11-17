package hot100;

import java.util.Stack;

public class t19removeNthFromEnd {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1, head);
            ListNode curr = dummy;
            Stack<ListNode> stack = new Stack<ListNode>();
            while(curr != null) {
                stack.push(curr);
                curr = curr.next;
            }
            for (int i = 0; i < n; i++) {
                stack.pop();
            }
            stack.peek().next = stack.peek().next.next;
            return dummy.next;
        }
    }
}
