package hot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class t32longestValidParentheses {
}

class t32Solution {
    public int longestValidParentheses(String s) {
        // int inValid = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}