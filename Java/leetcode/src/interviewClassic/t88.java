package interviewClassic;

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = nums1.clone();
        int ptr1 = 0, ptr2 = 0, idx = 0;
        while (ptr1 < m && ptr2 < n) {
            if (tmp[ptr1] <= nums2[ptr2]) {
                nums1[idx++] = tmp[ptr1++];
            } else {
                nums1[idx++] = nums2[ptr2++];
            }
        }
        while (ptr1 < m) {
            nums1[idx++] = tmp[ptr1++];
        }
        while (ptr2 < n) {
            nums1[idx++] = nums2[ptr2++];
        }
    }
}

public class t88 {

    public static void main(String[] args) {
        Solution88 solution = new Solution88();

    }

}
