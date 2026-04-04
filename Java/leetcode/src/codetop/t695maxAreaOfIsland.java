package codetop;

public class t695maxAreaOfIsland {
    public static void main(String[] args) {
        int grid[][] = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        t695Solution obj = new t695Solution();
        System.out.println(obj.maxAreaOfIsland(grid));
    }
}

class t695Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }

        if (grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;

        int up = dfs(grid, x - 1, y) ;
        int right = dfs(grid, x, y + 1);
        int down = dfs(grid, x + 1, y);
        int left = dfs(grid, x, y - 1);

        return 1 + up + right + down + left;
    }
}
