package hot100;

public class t4findMedianSortedArrays {
}

class t4Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m)
            return findMedianSortedArrays(nums2, nums1);

        int k = (m + n + 1) / 2;
        int left = 0, right = n;
        while(left < right) {
            int m1 = (right + left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                left = m1 + 1;
            else
                right = m1;
        }

        int m1 = left;
        int m2 = k - left;
        int c1 = Math.max(m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
        if ((n + m) % 2 == 1)
            return c1;
        int c2 = Math.min( m1 >= n ? Integer.MAX_VALUE :nums1[m1],
                m2 >= m ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
    }
}

/*

1 2 3
4 5 6

4 5 6 7 8
1 2 3

 */
