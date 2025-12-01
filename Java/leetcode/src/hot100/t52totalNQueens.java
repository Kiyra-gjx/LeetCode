package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t52totalNQueens {
    class Solution {
        private int ans = 0;

        public int totalNQueens(int n) {
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            dfs(queens, n, 0, 0, 0, 0);
            return ans;
        }

        void dfs(int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
            if (row == n) {
                ans++;
            } else {
                int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
                while(availablePositions != 0) {
                    int position = availablePositions & (-availablePositions);
                    availablePositions = availablePositions & (availablePositions - 1);
                    int column = Integer.bitCount(position - 1);
                    queens[row] = column;
                    dfs(queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                    queens[row] = -1;
                }
            }
        }
    }
}
