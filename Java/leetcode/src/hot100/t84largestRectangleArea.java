package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class t84largestRectangleArea {
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while(!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                ans = Math.max(ans, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return ans;
    }
}
