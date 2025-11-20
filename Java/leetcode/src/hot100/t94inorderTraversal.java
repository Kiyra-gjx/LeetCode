package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class t94inorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        class Node {
            Integer color;
            TreeNode root;
            Node(Integer color, TreeNode root) {this.color = color; this.root = root; }
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<> ();
            Stack<Node> stack = new Stack<>();
            if (root == null) return ans;
            stack.push(new Node(0, root));
            while(!stack.isEmpty()) {
                Node node = stack.pop();
                if (node.root == null) {
                    continue;
                } else if (node.color == 1) {
                    ans.add(node.root.val);
                } else {
                    stack.push(new Node(0, node.root.right));
                    stack.push(new Node(1, node.root));
                    stack.push(new Node(0, node.root.left));
                }
            }
            return ans;
        }
    }
}
