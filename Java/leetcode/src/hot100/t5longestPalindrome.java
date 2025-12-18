package hot100;

public class t5longestPalindrome {
}

class t5Solution {
    public String longestPalindrome(String s) {
        boolean[] dp = new boolean[s.length()];
        int head = 0, tail = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j] = true;
                } else if (j == i - 1) {
                    dp[j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[j] = s.charAt(j) == s.charAt(i) && dp[j + 1];
                }
                if (dp[j] && i - j > tail - head) {
                    head = j;
                    tail = i;
                }
            }
        }

        return s.substring(head, tail + 1);
    }
}
