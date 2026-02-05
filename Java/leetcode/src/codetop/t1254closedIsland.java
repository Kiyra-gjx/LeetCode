package codetop;


public class t1254closedIsland {
    public static void main(String[] args) {
        t1254Solution t = new t1254Solution();
        int[][] grid = new int[][] {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        System.out.println(t.closedIsland(grid));
    }
}

class t1254Solution {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        boolean up = dfs(grid, x - 1, y);
        boolean down = dfs(grid, x + 1, y);
        boolean left = dfs(grid, x, y - 1);
        boolean right = dfs(grid, x, y + 1);
        return up && down && left && right;
    }
}
