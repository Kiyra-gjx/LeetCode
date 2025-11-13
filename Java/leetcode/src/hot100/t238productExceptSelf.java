package hot100;

import java.util.ArrayList;

public class t238productExceptSelf {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i == nums.length - 1) {
                    ans.addFirst(nums[i]);
                } else {
                    ans.addFirst(nums[i] * ans.getFirst());
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    ans.set(i, ans.get(i + 1));
                } else if (i == ans.size() - 1) {
                    ans.set(i, nums[i - 1]);
                } else {
                    nums[i] = nums[i] * nums[i - 1];
                    ans.set(i, nums[i - 1] * ans.get(i + 1));
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
