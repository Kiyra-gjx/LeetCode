package codetop;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class t82deleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        t82Solution t = new t82Solution();
        System.out.println(t.deleteDuplicates(head));
    }
}


class t82Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(101);
        ListNode curr = head;
        ListNode prev = dummy;
        int tag = 101;

        while(curr != null) {
            if (curr.next != null) {
                if (curr.val == curr.next.val) {
                    tag = curr.val;
                }
            }
            if (curr.val == tag) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}