package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class t46permute {
    class Solution {
        private List<List<Integer>> list;
        private List<Integer> res;

        public List<List<Integer>> permute(int[] nums) {
            this.list = new ArrayList<>();
            this.res = new ArrayList<>();

            for (int num : nums) {
                res.add(num);
            }

            dfs(0);

            return list;
        }

        private void dfs(int x) {
            if (x == res.size() - 1) {
                list.add(new ArrayList<>(res));
                return;
            }
            for (int i = x; i < res.size(); i++) {
                Collections.swap(res, i, x);              // 交换，将 nums[i] 固定在第 x 位
                dfs(x + 1);              // 开启固定第 x + 1 位元素
                Collections.swap(res, i, x);              // 恢复交换
            }

        }
    }
}
