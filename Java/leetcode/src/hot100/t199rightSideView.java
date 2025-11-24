package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t199rightSideView {
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
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return new ArrayList<Integer> ();
            List<Integer> ans = new ArrayList<Integer>();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(root);
            while(!q.isEmpty()) {
                int size = q.size();
                TreeNode now = null;
                while(size-- != 0) {
                    now = q.poll();
                    if (now.left != null) {
                        q.add(now.left);
                    }
                    if (now.right != null) {
                        q.add(now.right);
                    }
                }
                ans.add(now.val);
            }
            return ans;
        }
    }
}
