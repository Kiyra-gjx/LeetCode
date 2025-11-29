package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class t47permuteUnique {
    class Solution {
        private List<List<Integer>> list;
        private List<Integer> res;

        public List<List<Integer>> permuteUnique(int[] nums) {
            list = new ArrayList<>();
            res = new ArrayList<>();

            for (int num : nums) {
                res.add(num);
            }
            dfs(0);
            return list;
        }

        private void dfs(int x) {
            if (x == res.size() - 1) {
                list.add(new ArrayList<>(res));  // 修复1：创建拷贝
                return;
            }

            // 用于去重的集合
            boolean[] used = new boolean[21];

            for (int i = x; i < res.size(); i++) {
                // 跳过重复元素
                if (used[res.get(i) + 10]) {
                    continue;
                }
                used[res.get(i) + 10] = true;

                // 交换
                Collections.swap(res, i, x);
                // 递归到下一层
                dfs(x + 1);
                // 回溯 - 直接交换回来，不需要修改used数组
                Collections.swap(res, i, x);
            }
        }
    }
}