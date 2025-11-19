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
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) return head;
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;
            while(fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            return merge(list1, list2);
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
