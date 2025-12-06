package daily;

import java.util.TreeMap;

public class t3578countPartitions {
    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 3, 7};
    }
}

class t3578Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int mod = (int) (1e9 + 7);
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < n; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            while(j <= i && cnt.lastKey() - cnt.firstKey() > k) {
                cnt.put(nums[j], cnt.get(nums[j]) - 1);
                if (cnt.get(nums[j]) == 0) {
                    cnt.remove(nums[j]);
                }
                j++;
            }
            dp[i + 1] = (prefix[i + 1] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }
        return (int) dp[n];
    }
}
