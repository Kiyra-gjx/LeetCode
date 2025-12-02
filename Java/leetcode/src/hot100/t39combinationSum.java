package hot100;

import java.util.ArrayList;
import java.util.List;

public class t39combinationSum {
    class Solution {
        List<List<Integer>> ans;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            dfs(curr, 0, 0, candidates, target);
            return ans;
        }

        void dfs(List<Integer> curr, int sum, int idx, int[] candidates, int target) {
            if (sum == target) {
                ans.add(new ArrayList<>(curr));
                return;
            } else if (sum > target || idx == candidates.length) {
                return;
            }
            // 选择当前元素
            curr.add(candidates[idx]);
            dfs(curr, sum + candidates[idx], idx, candidates, target);
            // 不选当前元素
            curr.removeLast();
            dfs(curr, sum, idx + 1, candidates, target);
        }
    }
}
