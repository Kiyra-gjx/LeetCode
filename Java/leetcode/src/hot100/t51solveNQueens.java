package hot100;

import java.util.*;

public class t51solveNQueens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            dfs(ans, queens, n, 0, 0, 0, 0);
            return ans;
        }

        void dfs(List<List<String>> ans, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
            if (row == n) {
                List<String> board = generateBoard(queens, n);
                ans.add(board);
            } else {
                int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
                while(availablePositions != 0) {
                    int position = availablePositions & (-availablePositions);
                    availablePositions = availablePositions & (availablePositions - 1);
                    int column = Integer.bitCount(position - 1);
                    queens[row] = column;
                    dfs(ans, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                    queens[row] = -1;
                }
            }
        }

        private List<String> generateBoard(int[] queens, int n) {
            List<String> board = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }
}
