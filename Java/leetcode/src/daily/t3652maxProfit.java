package daily;

public class t3652maxProfit {
}

class t3652Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long[] pre = new long[prices.length];
        long[] pricesP = new long[prices.length];
        for (int i = 0; i < prices.length; i++) {
            pre[i] = (i == 0 ? prices[0] : pre[i - 1] + prices[i]);
            pricesP[i] = (i == 0 ? 0 : pricesP[i - 1]) + (long) prices[i] * strategy[i];
        }

        int n = prices.length;
        long ans = pricesP[n - 1];
        for (int i = 0; i <= n - k; i++) {
            int j = Math.min(n - 1, i + k - 1);
            long sumPre = (i > 0 ? pricesP[i - 1] : 0);
            long sumSuff = (j < n - 1 ? pricesP[n - 1] - pricesP[j] : 0);
            long sumMid =  pre[j] - pre[i + k / 2 - 1];
            ans = Math.max(ans, sumMid + sumPre + sumSuff);
        }

        return ans;
    }
}
