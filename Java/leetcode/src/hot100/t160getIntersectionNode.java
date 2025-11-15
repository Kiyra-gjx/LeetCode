package hot100;


import java.util.HashSet;

public class t160getIntersectionNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int cnt1 = 0;
            ListNode p1 = headA, p2 = headB;
            while(headA != null) {
                headA = headA.next;
                cnt1++;
            }
            int cnt2 = 0;
            while(headB != null) {
                headB = headB.next;
                cnt2++;
            }
            if (cnt1 <= cnt2) {
                for (int i = 0; i < cnt2 - cnt1; i++) {
                    p2 = p2.next;
                }
            } else {
                for (int i = 0; i < cnt1 - cnt2; i++) {
                    p1 = p1.next;
                }
            }
            while(p1 != null && p2 != null) {
                if (p1 == p2) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return null;
        }
    }
}
