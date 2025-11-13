package interviewClassic;

import java.util.ArrayList;
import java.util.Arrays;

// class Solution {
class Solution27 {
    public int removeElement(int[] nums, int val) {
        int fast =  0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}

public class t27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        Solution27 s = new Solution27();
        s.removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
    }
}
