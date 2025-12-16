package hot100;

public class t152maxProduct {
}

class t152Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int preMax = nums[0], preMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = preMax, mn = preMin;
            preMax = Math.max(nums[i] * mx, Math.max(nums[i], nums[i] * mn));
            preMin = Math.min(nums[i] * mn, Math.min(nums[i], nums[i] * mx));
            ans = Math.max(ans, preMax);
        }

        return ans;
    }
}
