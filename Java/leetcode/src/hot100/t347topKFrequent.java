package hot100;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class t347topKFrequent {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] m, int[] n) -> {
            return m[1] - n[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek()[1] < cnt) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[] {num, cnt});
                }
            } else {
                priorityQueue.offer(new int[] {num, cnt});
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}
