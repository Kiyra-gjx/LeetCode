package daily;

import java.util.*;

public class t1878getBiggestThree {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        t1878Solution t = new t1878Solution();
        System.out.println(Arrays.toString(t.getBiggestThree(grid)));
    }
}

class t1878Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] sum1 = new int[n + 2][m + 2];
        int[][] sum2 = new int[n + 2][m + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum1[i + 1][j + 1] = grid[i][j] + sum1[i][j];
                sum2[i + 1][j + 1] = grid[i][j] + sum2[i][j + 2];
            }
        }

        Set<Integer> ans = new LinkedHashSet<>();

        for (int len = 0; len <= Math.min(n, m) / 2; len++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int x = i, y = j;
                    int x1 = i + len, y1 = j - len;
                    int x2 = i + 2 * len, y2 = j;
                    int x3 = i + len, y3 = j + len;

                    if (x1 < 0 || x2 < 0 || x3 < 0 || x1 >= n || x2 >= n || x3 >= n) {
                        continue;
                    }
                    if (y1 < 0 || y2 < 0 || y3 < 0 || y1 >= m || y2 >= m || y3 >= m) {
                        continue;
                    }

                    int res = (sum1[x3 + 1][y3 + 1] - sum1[x][y]) +
                            (sum1[x2 + 1][y2 + 1] - sum1[x1][y1]) +
                            (sum2[x1][y1 + 2] - sum2[x + 1][y + 1]) +
                            (sum2[x2][y2 + 2] - sum2[x3 + 1][y3 + 1]);

                    if (ans.size() < 3) {
                        ans.add(res);
                    } else {
                        int curr = ans.iterator().next();
                        if (curr < res) {
                            ans.clear();
                            ans.add(res);
                        }

                    }
                }
            }
        }

        int[] ret = new int[ans.size()];
        int idx = ans.size() - 1;
        while(!ans.isEmpty()) {
            ans.clear();
            idx--;
        }

        return ret;
    }
}
