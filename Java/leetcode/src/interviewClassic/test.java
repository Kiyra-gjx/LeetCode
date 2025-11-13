//
// public
//
// public int findPeakElement (int[] nums) {
//     int left = 0;
//     int right = nums.length - 1;
//     while(left < right){
//         int mid = (left + right) / 2;
// // 右边是往下，不一定有坡峰
//         if(nums[mid] > nums[mid + 1])
//             right = mid;
// // 右边是往上，一定能找到波峰
// else
//         left = mid;
//     }
// // 返回其中一个波峰
//     return right;
// }