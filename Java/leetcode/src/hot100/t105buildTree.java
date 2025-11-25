package hot100;

public class t105buildTree {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(0, preorder.length - 1, preorder,
                    0, inorder.length - 1, inorder);
        }

        public TreeNode build(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder) {
            if (preStart > preEnd) return null;

            // 当前子树的根节点值
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);

            // 在中序遍历中找到根节点位置
            int inRoot = inStart;
            while (inRoot <= inEnd && inorder[inRoot] != rootVal) {
                inRoot++;
            }

            // 左子树长度
            int leftSize = inRoot - inStart;

            // 递归构造左子树
            root.left = build(preStart + 1, preStart + leftSize, preorder, inStart, inRoot - 1, inorder);

            // 递归构造右子树
            root.right = build(preStart + leftSize + 1, preEnd,preorder, inRoot + 1,inEnd, inorder);

            return root;
        }
    }

    public static void main(String[] args) {
        t105buildTree outer = new t105buildTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution sol = outer.new Solution();
        TreeNode root = sol.buildTree(preorder, inorder);

    }
}
