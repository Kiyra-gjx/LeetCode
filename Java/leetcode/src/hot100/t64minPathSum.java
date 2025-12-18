package hot100;

public class t64minPathSum {
}

class t64Solution {
    public int minPathSum(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        ans[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            ans[i][0] = grid[i][0] + ans[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            ans[0][i] = grid[0][i] + ans[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                ans[i][j] = grid[i][j] + Math.min(ans[i - 1][j], ans[i][j - 1]);
            }
        }
        // return ans[2][2];
        return ans[ans.length - 1][ans[0].length - 1];
    }
}
