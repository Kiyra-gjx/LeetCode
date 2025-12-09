package hot100;

public class t215findKthLargest {
}

class Solution {
    int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[k];
        int x = nums[left], i = left - 1, j = right + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickselect(nums, left, j, k);
        else return quickselect(nums, j + 1, right, k);
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }
}
