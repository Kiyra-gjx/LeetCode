package hot100;

import java.util.PriorityQueue;

public class t215findKthLargest {
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> {
            return b - a;
        });
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                return pq.peek();
            }
            pq.poll();
        }

        return nums[0];
    }
}
