package hot100;

public class t215findKthLargest {
}

class t215Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        heapBuild(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            heapModify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void heapBuild(int[] nums, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapModify(nums, i, heapSize);
        }
    }

    private void heapModify(int[] nums, int i, int heapSize) {
        int l = 2 * i + 1, r = 2 * i + 2;
        int largest = i;
        if (l < heapSize && nums[largest] < nums[l]) {
            largest = l;
        }
        if (r < heapSize && nums[largest] < nums[r]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, largest, i);
            heapModify(nums, largest, heapSize);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}