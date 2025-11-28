package hot100;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class t994orangesRotting {
    class Solution {
        public int orangesRotting(int[][] grid) {
            // 初始化数据
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            int n = grid.length, m = grid[0].length;
            int cnt = 0;    // 新鲜橘子数量

            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        q.offer(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        cnt++;
                    }
                }
            }

            // 判断是否输出 -1
            if (q.isEmpty() && cnt != 0) {
                return -1;
            }

            int ans = 0;
            while(!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] pos = q.poll();
                    int x = pos[0];
                    int y = pos[1];

                    for (int j = 0; j < 4; j++) {
                        int dx = x + dr[j];
                        int dy = y + dc[j];
                        if (dx >= 0 && dy >= 0 && dx < n && dy < m && grid[dx][dy] == 1) {
                            grid[dx][dy] = 2;
                            q.offer(new int[]{dx, dy});
                            cnt--;
                        }
                    }
                }
                if (!q.isEmpty()) {
                    ans++;
                }
            }

            if (cnt != 0) return -1;

            return ans;
        }
    }
}
