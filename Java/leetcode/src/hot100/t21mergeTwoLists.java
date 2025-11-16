package hot100;

public class t21mergeTwoLists {
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
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 使用虚拟头节点简化操作
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            ListNode p1 = list1, p2 = list2;

            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    current.next = p1;  // 直接连接原有节点，避免创建新节点
                    p1 = p1.next;
                } else {
                    current.next = p2;
                    p2 = p2.next;
                }
                current = current.next;  // 移动当前指针
            }

            // 处理剩余节点
            if (p1 != null) {
                current.next = p1;
            } else {
                current.next = p2;
            }

            return dummy.next;  // 返回真正的头节点
        }
    }
}
