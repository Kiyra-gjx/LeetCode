package hot100;

import java.util.HashMap;
import java.util.Map;

public class t230kthSmallest {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            MyBst bst = new MyBst(root);
            return bst.kthSmallest(k);
        }
    }

    class MyBst {
        TreeNode root;
        Map<TreeNode, Integer> nodeNum;

        public MyBst(TreeNode root) {
            this.root = root;
            this.nodeNum = new HashMap<TreeNode, Integer>();
            countNodeNum(root);
        }

        public int kthSmallest(int k) {
            TreeNode node = root;
            while(node != null) {
                int left = getNodeNum(node.left);
                if (left < k - 1) {
                    node = node.right;
                    k -= left + 1;
                } else if (left == k - 1) {
                    break;
                } else {
                    node = node.left;
                }
            }
            return node.val;
        }

        private int countNodeNum(TreeNode node) {
            if (node == null) return 0;
            nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
            return nodeNum.get(node);
        }

        private int getNodeNum(TreeNode node) {
            return nodeNum.getOrDefault(node, 0);
        }
    }
}
