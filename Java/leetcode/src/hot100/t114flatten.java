package hot100;

public class t114flatten {
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
        public void flatten(TreeNode root) {
            process(root);
        }

        public void process(TreeNode node) {
            if (node == null) return;

            process(node.left);
            process(node.right);

            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;

            TreeNode curr = node;
            while(curr.right != null) {
                curr = curr.right;
            }
            curr.right = temp;
        }
    }
}
