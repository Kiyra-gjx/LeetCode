package interviewClassic;

import java.util.Arrays;

class Solution80 {
// class Solution {
    public int removeDuplicates(int[] nums) {
        int slow1 = 1;
        boolean cnt = false;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow1++] = nums[fast];
                cnt = false;
            } else {
                if (!cnt) {
                    cnt = true;
                    nums[slow1++] = nums[fast];
                }
            }
        }
        return slow1;
    }
}

public class t80 {
    public static void main(String[] args) {
        Solution80 s = new Solution80();
        int[] nums = {1, 1, 1, 2, 2, 3};
        s.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
