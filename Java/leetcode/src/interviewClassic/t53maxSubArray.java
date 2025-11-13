package interviewClassic;

public class t53maxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxNum = nums[0];
            for (int i = 0; i < nums.length; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                maxNum = Math.max(maxNum, pre);
            }
            return maxNum;
        }
    }
}
