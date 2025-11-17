package hot100;

public class t25reverseKGroup {
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
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int cnt = 0;
            ListNode cntNode = head;
            while(cntNode != null) {
                cnt++;
                cntNode = cntNode.next;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode start = head;

            while (cnt >= k) {
                // 反转当前k个节点，返回反转后的新头节点
                ListNode[] result = reverse(start, k);
                ListNode newHead = result[0];
                ListNode nextStart = result[1];

                // 连接反转后的段
                prev.next = newHead;
                start.next = nextStart;

                // 更新指针
                prev = start;
                start = nextStart;
                cnt -= k;
            }

            return dummy.next;
        }

        // 返回反转后的头节点和下一段的起始节点
        static ListNode[] reverse(ListNode head, int k) {
            int count = 0;
            ListNode prev = null;
            ListNode curr = head;
            ListNode nextTemp = null;

            while (curr != null && count < k) {
                nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
                count++;
            }

            // 返回反转后的头节点和下一段的起始节点
            return new ListNode[]{prev, curr};
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
    }
}
