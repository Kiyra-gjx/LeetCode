package hot100;

public class t41firstMissingPositive {
    static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    nums[i] = nums.length + 1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                int num = Math.abs(nums[i]);
                if (num <= nums.length) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }
}
