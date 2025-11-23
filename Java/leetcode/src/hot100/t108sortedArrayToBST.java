package hot100;

public class t108sortedArrayToBST {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return recurse(nums, 0, nums.length - 1);
        }

        public TreeNode recurse (int[] nums, int l, int r) {
            if (l > r) return null;
            TreeNode root = new TreeNode();
            int mid = (l + r) / 2;
            root.val = nums[mid];
            root.left = recurse(nums, l, mid - 1);
            root.right = recurse(nums, mid + 1, r);
            return root;
        }
    }
}
