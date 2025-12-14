package hot100;

import java.util.Arrays;

public class t300lengthOfLIS {
}

class t300Solution {
    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length + 1];
        d[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == d[len]) {
                continue;
            } else if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len;
                int idx = len;
                while(left <= right) {
                    int mid = (left + right) / 2;
                    if (d[mid] >= nums[i]) {
                        idx = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                d[idx] = nums[i];
            }
        }

        return len;
    }
}
