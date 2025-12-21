package hot100;

public class t278findDuplicate {
}

class t278Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i + 1]);
            if (nums[num] == -num) {
                return num;
            } else {
                nums[num] = -nums[num];
            }
        }

        return 0;
    }
}
