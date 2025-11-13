package interviewClassic;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int ll = intervals[0][0], rr = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int l =  intervals[i][0], r = intervals[i][1];
            if (rr < l) {
                res.add(new int[]{ll, rr});
                ll = l;
                rr = r;
            } else {
                rr = Math.max(r, rr);
            }
        }
        res.add(new int[]{ll, rr});
        return res.toArray(new int[res.size()][]);
    }
}

public class t56merge {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
