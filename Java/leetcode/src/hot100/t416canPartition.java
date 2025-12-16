package hot100;

import java.util.Arrays;

public class t416canPartition {
}

class t416Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }
        if (target % 2 == 1) {
            return false;
        }
        target /= 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
        }

        return dp[target];
    }
}
