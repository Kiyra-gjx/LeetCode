package hot100;

public class t104maxDepth {
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
        int dfs(TreeNode fa) {
            int depth = 0;
            if (fa == null) return depth;
            depth++;
            return Math.max(depth + dfs(fa.left), depth + dfs(fa.right));
        }

        public int maxDepth(TreeNode root) {
            return dfs(root);
        }
    }
}
