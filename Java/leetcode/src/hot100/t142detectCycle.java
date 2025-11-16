package hot100;

public class t142detectCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
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

    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode slow = head, fast = head;
            boolean hasCycle = false;

            // 第一步：判断是否有环
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    hasCycle = true;
                    break;
                }
            }

            // 如果没有环，直接返回null
            if (!hasCycle) {
                return null;
            }

            // 第二步：寻找环的入口节点
            // 将一个指针重置到头部，两个指针以相同速度前进，相遇点即为环入口
            ListNode ptr1 = head;
            ListNode ptr2 = slow;  // 或者fast，此时slow==fast

            while (ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            return ptr1;  // 或者ptr2，此时它们相等
        }
    }
}
