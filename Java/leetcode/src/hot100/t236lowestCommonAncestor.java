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

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            Map<TreeNode, TreeNode> fa = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // 记录每个节点的父节点
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                // 左节点
                if (node.left != null) {
                    fa.put(node.left, node);
                    queue.offer(node.left);
                }
                // 右节点
                if (node.right != null) {
                    fa.put(node.right, node);
                    queue.offer(node.right);
                }
            }

            // 遍历 p 的父节点（包括自身）
            Set<TreeNode> pFa = new HashSet<> ();
            while(p != null) {
                pFa.add(p);
                p = fa.get(p);
            }

            // 遍历 q 的父节点，只要在 pFa 里找到，就直接返回
            while(q != null && !pFa.contains(q)) {
                q = fa.get(q);
            }

            return q;
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
