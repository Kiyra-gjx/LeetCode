package hot100;

import java.util.ArrayList;
import java.util.List;

public class t78subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            dfs(ans, current, 0, nums);
            return ans;
        }

        void dfs(List<List<Integer>> ans, List<Integer> current, int index, int[] nums) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(current));  // 到达末尾，添加当前子集
                return;
            }

            // 选择当前元素
            current.add(nums[index]);
            dfs(ans, current, index + 1, nums);

            // 不选择当前元素
            current.removeLast();
            dfs(ans, current, index + 1, nums);
        }
    }
}
