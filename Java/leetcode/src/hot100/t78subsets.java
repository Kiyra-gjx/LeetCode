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
            ans.add(new ArrayList<>(current));

            for (int i = index; i < nums.length; i++) {
                // 选择当前元素
                current.add(nums[i]);
                // 递归处理下一个元素
                dfs(ans, current, i + 1, nums);
                // 回溯，不选择当前元素
                current.removeLast();
            }
        }
    }
}
