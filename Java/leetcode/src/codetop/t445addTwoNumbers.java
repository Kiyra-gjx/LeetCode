package codetop;

public class t445addTwoNumbers {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        t445Solution t445Solution = new t445Solution();
        System.out.println(t445Solution.addTwoNumbers(l1, l2));
    }
}

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
class t445Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = reverse(l1);
        ListNode n2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        int plus = 0;
        while(n1 != null && n2 != null) {
            head.next = new ListNode(n1.val + n2.val + plus);
            head = head.next;
            plus = head.val / 10;
            head.val %= 10;

            n1 = n1.next;
            n2 = n2.next;
        }

        if (n1 != null) {
            head.next = new ListNode(n1.val);
        } else if (n2 != null) {
            head.next = new ListNode(n2.val);
        }

        while(head.next != null) {
            head = head.next;
            head.val += plus;
            plus = head.val / 10;
            head.val %= 10;
        }

        if (plus != 0) {
            head.next = new ListNode(plus);
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode curr = head.next;

        pre.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
