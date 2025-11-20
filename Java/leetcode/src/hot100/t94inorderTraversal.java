package hot100;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Integer> ans = new ArrayList<> ();
        public List<Integer> inorderTraversal(TreeNode root) {
            recurse(root);
            return ans;
        }

        public void recurse(TreeNode root) {
            if (root == null) return;
            recurse(root.left);
            ans.add(root.val);
            recurse(root.right);
        }
    }
}
