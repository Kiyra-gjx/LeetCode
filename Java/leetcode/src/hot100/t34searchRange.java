package hot100;

public class t34searchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int ansLeft = -1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    ansLeft = mid;
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            left = 0;
            right = nums.length - 1;
            int ansRight = -1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    ansRight = mid;
                    left = mid + 1;
                } else if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return new int[] {ansLeft, ansRight};
        }
    }
}
