package hot100;

public class t33search {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        t33search t = new t33search();
        Solution sol = t.new Solution();
        int[] nums = new int[] {5, 1, 3};
        System.out.println(sol.search(nums, 5));
    }
}
