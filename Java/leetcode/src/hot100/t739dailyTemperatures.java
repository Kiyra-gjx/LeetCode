package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class t739dailyTemperatures {
}

class t739Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperature) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            temperatures[stack.pop()] = 0;
        }

        return ans;
    }
}
