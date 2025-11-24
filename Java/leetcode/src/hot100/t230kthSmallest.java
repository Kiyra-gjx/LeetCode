package hot100;

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
        int res, k;

        void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (k == 0) return;
            if (--k == 0) this.res = root.val;
            dfs(root.right);
        }

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return this.res;
        }
    }
}
