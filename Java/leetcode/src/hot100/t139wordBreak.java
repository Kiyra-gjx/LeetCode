package hot100;

import java.util.List;

public class t139wordBreak {
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String str : wordDict) {
                int len = str.length();
                if (i + 1 >= len && s.substring(i + 1 - len, i + 1).equals(str) && dp[i + 1] == false) {
                    dp[i + 1] = dp[i + 1 - len];
                }
            }
        }

        return dp[s.length()];
    }
}
