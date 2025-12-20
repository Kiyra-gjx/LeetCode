package hot100;

public class t75sortColors {
}

class t75Solution {
    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt0++;
            } else if (num == 1) {
                cnt1++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (cnt0 > 0) {
                cnt0--;
                nums[i] = 0;
            } else if (cnt1 > 0) {
                cnt1--;
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
