package hot100;

import java.util.HashMap;

public class t138copyRandomList {
    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            Node curr = head;
            HashMap<Node, Node> map = new HashMap<>();

            while(curr != null) {
                map.put(curr, new Node(curr.val));
                curr = curr.next;
            }
            curr = head;

            while(curr != null) {
                Node newCurr = map.get(curr);

                if (curr.next != null) {
                    newCurr.next = map.get(curr.next);
                }
                if(curr.random!=null)
                {
                    newCurr.random=map.get(curr.random);
                }

                curr = curr.next;
            }

            return map.get(head);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Solution sol = new Solution();
        System.out.println(sol.copyRandomList(head));
    }
}
