package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t17letterCombinations {
    class Solution {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            dfs(ans, sb, 0, digits);
            return ans;
        }

        void dfs(List<String> ans, StringBuilder sb, int idx, String digits) {
            if (idx == digits.length()) {
                ans.add(String.valueOf(sb));
                return;
            }
            char digit = digits.charAt(idx);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int j = 0;  j < lettersCount; j++) {
                sb.append(letters.charAt(j));
                dfs(ans, sb, idx + 1, digits);
                sb.deleteCharAt(idx);
            }
        }
    }

    public static void main(String[] args) {
        t17letterCombinations t = new t17letterCombinations();
        Solution sol = t.new Solution();
        String digits = "23";
        System.out.println(sol.letterCombinations(digits));
    }
}
