package hot100;

import java.util.Stack;

public class t20isValid {
    public static void main(String[] args) {
        t20Solution t = new t20Solution();
        System.out.println(t.isValid("()"));
    }
}

class t20Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.add(c);
            } else {
                if (c == ')') {
                    c = '(';
                } else if (c == ']') {
                    c = '[';
                } else {
                    c = '{';
                }
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
