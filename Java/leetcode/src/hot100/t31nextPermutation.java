package hot100;

public class t31nextPermutation {
    public static void main(String[] args) {
        t31Solution sol = new t31Solution();
        int[] nums = {3, 2, 1};
        sol.nextPermutation(nums);
    }
}

class t31Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int head = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                head = i;
                break;
            }
        }

        if (head != 0) {
            for (int i = n - 1; i >= head; i--) {
                if (nums[head - 1] < nums[i]) {
                    swap(nums, head - 1, i);
                    break;
                }
            }
        }

        for (int i = n - 1; i > (head - 1 + n) / 2; i--) {
            swap(nums, i, n - 1 + head - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
