package hot100;

import java.util.HashMap;
import java.util.Map;

public class t437pathSum {
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
        private int count = 0;
        private Map<Long, Integer> prefixSum = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            prefixSum.put(0L, 1); // 前缀和为0出现1次
            dfs(root, 0L, targetSum);
            return count;
        }

        void dfs(TreeNode node, long currSum, int target) {
            if (node == null) return;

            // 更新当前前缀和
            currSum += node.val;

            // 看有没有 currSum - target 的前缀和
            count += prefixSum.getOrDefault(currSum - target, 0);

            // 记录当前前缀和出现次数
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

            // 递归左右子树
            dfs(node.left, currSum, target);
            dfs(node.right, currSum, target);

            // 回溯：离开这个节点时，撤销刚才的记录
            prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        }
    }

}
