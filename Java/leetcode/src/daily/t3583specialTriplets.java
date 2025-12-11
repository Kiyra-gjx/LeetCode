package daily;

import java.util.HashMap;

public class t3583specialTriplets {
}

class t3583Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        HashMap<Integer, Integer> allCnt = new HashMap<>();
        HashMap<Integer, Integer> currCnt = new HashMap<>();
        for (int num : nums) {
            allCnt.put(num, allCnt.getOrDefault(num, 0) + 1);
        }

        long ans = 0;
        for (int num : nums) {
            int target = num * 2;
            int leftCnt = currCnt.getOrDefault(target, 0);
            currCnt.put(num, currCnt.getOrDefault(num, 0) + 1);
            int rightCnt = allCnt.getOrDefault(target, 0) - currCnt.getOrDefault(target, 0);
            ans = (ans + (long) leftCnt * rightCnt % MOD) % MOD;
        }

        return (int)ans;
    }
}
