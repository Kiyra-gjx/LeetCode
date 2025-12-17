package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class t32longestValidParentheses {
}

class t32Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * left);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * left);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }

        return ans;
    }
}