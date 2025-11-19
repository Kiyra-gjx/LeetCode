package hot100;

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
            if (head == null) {
                return null;
            }
            int length = 0;
            ListNode node = head;
            while(node != null) {
                length++;
                node = node.next;
            }
            ListNode dummy = new ListNode(-1, head);
            for (int len = 1; len < length; len <<= 1) {
                ListNode prev = dummy, curr = dummy.next;
                while(curr != null) {
                    ListNode head1 = curr;
                    for (int i = 1; i < len && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < len && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    prev.next = merge(head1, head2);
                    while(prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummy.next;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            ListNode ptr1 = head1, ptr2 = head2;
            while(ptr1 != null || ptr2 != null) {
                if (ptr1 == null) {
                    curr.next = ptr2;
                    break;
                } else if (ptr2 == null) {
                    curr.next = ptr1;
                    break;
                } else {
                    if (ptr1.val <= ptr2.val) {
                        curr.next = ptr1;
                        ptr1 = ptr1.next;
                    } else {
                        curr.next = ptr2;
                        ptr2 = ptr2.next;
                    }
                    curr = curr.next;
                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        Solution sol = new Solution();

        System.out.println(sol.sortList(head));
    }
}
