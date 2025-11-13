package interviewClassic;

class Solution121 {
// class Solution {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minValue);
            }
        }
        return maxProfit;
    }
}



public class t121 {
    public static void main(String[] args) {
        Solution121 s = new Solution121();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(arr));
    }
}
