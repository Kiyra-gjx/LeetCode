package hot100;

import java.util.LinkedList;
import java.util.Queue;

public class t200numIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;

            int count = 0;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        grid[i][j] = '0';

                        while (!queue.isEmpty()) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];

                            for (int[] dir : directions) {
                                int newX = x + dir[0];
                                int newY = y + dir[1];

                                if (newX >= 0 && newX < grid.length &&
                                        newY >= 0 && newY < grid[0].length &&
                                        grid[newX][newY] == '1') {
                                    queue.offer(new int[]{newX, newY});
                                    grid[newX][newY] = '0';
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        t200numIslands t = new t200numIslands();
        Solution sol = t.new Solution();
        char[][] grid = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};
        System.out.println(sol.numIslands(grid));
    }
}
