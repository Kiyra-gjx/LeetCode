package hot100;

public class t101isSymmetric {
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
        boolean dfs(TreeNode node1, TreeNode node2) {
            // 对称节点都为 null
            if (node1 == null && node2 == null) return true;
            if (node1 == null) {
                // 左节点为 null 但右节点不为 null
                return false;
            } else if (node2 == null) {
                // 右节点为 null 但左节点不为 null
                return false;
            } else if (node1.val != node2.val) {
                // 左右节点都不为 null
                return false;
            }
            // 判断外侧对应子树
            boolean flag1 = dfs(node1.left, node2.right);
            // 判断内侧对应子树
            boolean flag2 = dfs(node1.right, node2.left);
            // 只有内外侧都相等才返回 true
            return (flag1 && flag2);
        }

        public boolean isSymmetric(TreeNode root) {
            return dfs(root.left, root.right);
        }
    }
}
