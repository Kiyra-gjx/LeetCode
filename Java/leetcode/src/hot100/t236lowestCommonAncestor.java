package hot100;

import java.util.*;

public class t236lowestCommonAncestor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        TreeNode ans;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            check(root, p, q);
            return ans;
        }

        public boolean check(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }

            // 递归记录左、右节点是否包含 p 和 q
            boolean lson = check(root.left, p, q);
            boolean rson = check(root.right, p, q);

            if ((lson && rson) || ((lson || rson) && (root == p || root == q))) {
                ans = root;
            }

            return lson || rson || root == p || root == q;
        }
    }

    public static void main(String[] args) {
        t236lowestCommonAncestor t = new t236lowestCommonAncestor();
        Solution sol = t.new Solution();
        TreeNode root = t.new TreeNode(3);
        root.left = t.new TreeNode(5);
        root.left.right = t.new TreeNode(2);
        root.left.right.right = t.new TreeNode(4);
        System.out.println(sol.lowestCommonAncestor(root, root, root.left));
    }
}
