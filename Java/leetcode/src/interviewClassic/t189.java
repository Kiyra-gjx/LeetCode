package interviewClassic;

import java.util.Arrays;



class Solution189 {
// class Solution {

    public void reverse(int start, int end, int[] nums) {
        for (; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }
}

public class t189 {
    public static void main(String[] args) {
        Solution189 s = new Solution189();
        int[] nums = {1,2,3,4,5,6};
        s.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
