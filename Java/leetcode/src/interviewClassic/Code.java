package interviewClassic;

public class Code {
    public int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            // 右边是往下，不一定有坡峰
            if(nums[mid] > nums[mid + 1])
                right = mid;
            // 右边是往上，一定能找到波峰
            else
                left = mid + 1;
        }
// 返回其中一个波峰
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 7, 8, 4};
        System.out.println(new Code().findPeakElement(nums));
    }

}
