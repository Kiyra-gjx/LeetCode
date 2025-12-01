package hot100;

import java.util.ArrayList;
import java.util.List;

public class t57insert {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans = new ArrayList<>();
            int newStart = newInterval[0];
            int newEnd = newInterval[1];
            boolean inserted = false;
            for (int i = 0; i < intervals.length; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                if (newEnd < start) {
                    if (!inserted) {
                        ans.add(new int[]{newStart, newEnd});
                    }
                    inserted = true;
                    ans.add(new int[]{start, end});
                } else if (end < newStart) {
                    ans.add(new int[]{start, end});
                } else {
                    newStart = Math.min(newStart, start);
                    newEnd = Math.max(newEnd, end);
                }
            }
            if (!inserted) {
                ans.add(new int[]{newStart, newEnd});
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
}
