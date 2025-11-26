package hot100;

import java.util.*;
import java.util.stream.Stream;

public class t124maxPathSum {
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
        public int maxPathSum(TreeNode root) {
            // 先把所有的节点存下
            Queue<TreeNode> q = new LinkedList<TreeNode> ();    // bfs
            Deque<TreeNode> stack = new ArrayDeque<TreeNode> ();    // 存节点的队列
            // HashMap<TreeNode, TreeNode> fa = new HashMap<> ();  // 记录父节点
            q.offer(root);
            stack.push(root);
            while(!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                    stack.push(node.left);
                    // fa.put(node.left, node);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    stack.push(node.right);
                    // fa.put(node.right, node);
                }
            }

            HashMap<TreeNode, Integer> nodeNum = new HashMap<> ();
            int ans = (int) -1e8;
            // 从最底层逐层向上遍历节点
            while(!stack.isEmpty()) {
                TreeNode node = stack.poll();

                // 先把节点值初始化为自己的值
                nodeNum.put(node, node.val);

                // 对于左子树，ans = max(ans, ans + left)
                if (node.left != null) {
                    nodeNum.put(node, Math.max(node.val + nodeNum.get(node.left), node.val));
                }
                // 对于右子树，ans = max(ans, ans + right)
                if (node.right != null) {
                    nodeNum.put(node, Math.max(node.val + nodeNum.get(node.right), nodeNum.get(node)));
                }

                // 更新最大值
                ans = Math.max(ans,
                        Stream.of(
                                node.val,
                                node.val + nodeNum.getOrDefault(node.left, 0),
                                node.val + nodeNum.getOrDefault(node.right, 0),
                                node.val + nodeNum.getOrDefault(node.left, 0) + nodeNum.getOrDefault(node.right, 0)
                                ).max(Integer::compareTo).get()
                );
            }

            return ans;
        }
    }
}
