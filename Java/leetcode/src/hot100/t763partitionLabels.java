package hot100;

import java.util.ArrayList;
import java.util.List;

public class t763partitionLabels {
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26];
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            cnt[idx] = i;
        }
        int tail = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (i != cnt[idx]) {
                tail = Math.max(tail, cnt[idx]);
            } else if (i >= tail || i == s.length() - 1) {
                ans.add(i + 1 - pre);
                pre += ans.getLast();
            }
        }

        return ans;
    }
}
