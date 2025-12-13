package hot100;

public class t279numSquares {
}

class t279Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i - square] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}
