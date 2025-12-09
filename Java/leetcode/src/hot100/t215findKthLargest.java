package hot100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class t215findKthLargest {
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
