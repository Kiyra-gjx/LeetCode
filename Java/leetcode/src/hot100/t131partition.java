package hot100;

import java.util.ArrayList;
import java.util.List;

public class t131partition {
    class Solution {
        List<List<String>> ans;

        public List<List<String>> partition(String s) {
            ans = new ArrayList<>();
            dfs(new ArrayList<>(), 0, s);
            return ans;
        }

        void dfs(List<String> curr, int start, String s) {
            // 如果已经处理完整个字符串，将当前分割加入结果
            if (start == s.length()) {
                ans.add(new ArrayList<>(curr));
                return;
            }

            // 尝试所有可能的结束位置
            for (int end = start; end < s.length(); end++) {
                // 检查从start到end的子串是否是回文
                if (isPalindrome(s, start, end)) {
                    // 如果是回文，加入当前路径
                    curr.add(s.substring(start, end + 1));
                    // 递归处理剩余部分
                    dfs(curr, end + 1, s);
                    // 回溯，移除最后添加的子串
                    curr.removeLast();
                }
            }
        }

        // 辅助函数：判断子串是否是回文
        boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
