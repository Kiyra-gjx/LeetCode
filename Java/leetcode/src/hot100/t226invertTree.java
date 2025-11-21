package hot100;

public class t226invertTree {
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
        void dfs(TreeNode fa) {
            if (fa == null) return;
            TreeNode temp = fa.left;
            fa.left = fa.right;
            fa.right = temp;
            dfs(fa.left);
            dfs(fa.right);

        }

        public TreeNode invertTree(TreeNode root) {
            dfs(root);
            return root;
        }
    }
}
