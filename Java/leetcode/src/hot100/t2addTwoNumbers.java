package hot100;

public class t2addTwoNumbers {
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
        ListNode(int val) {};
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            int val = 0;
            ListNode p1 = l1, p2 = l2;
            while(p1 != null || p2 != null) {
                if (p1 == null) {
                    val += p2.val;
                    p2 = p2.next;
                } else if (p2 == null) {
                    val += p1.val;
                    p1 = p1.next;
                } else {
                    val += p1.val + p2.val;
                    p1 = p1.next;
                    p2 = p2.next;
                }
                curr.next = new ListNode(val % 10);
                curr = curr.next;
                val /= 10;
            }
            if (val > 0) {
                curr.next = new ListNode(val % 10);
            }
            return dummy.next;
        }
    }
}
