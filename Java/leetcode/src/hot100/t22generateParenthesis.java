package hot100;

import java.util.ArrayList;
import java.util.List;

public class t22generateParenthesis {
    class Solution {
        List<String> ans;

        public List<String> generateParenthesis(int n) {
            ans = new ArrayList<>();
            backtrack(new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backtrack(StringBuilder curr, int open, int close, int n) {
            // 如果字符串长度达到2n，添加到结果集
            if (curr.length() == 2 * n) {
                ans.add(curr.toString());
                return;
            }

            // 如果可以添加左括号
            if (open < n) {
                curr.append('(');
                backtrack(curr, open + 1, close, n);
                curr.deleteCharAt(curr.length() - 1); // 回溯
            }

            // 如果可以添加右括号（右括号数量必须小于左括号数量）
            if (close < open) {
                curr.append(')');
                backtrack(curr, open, close + 1, n);
                curr.deleteCharAt(curr.length() - 1); // 回溯
            }
        }
    }
}
