package hot100;

public class t79exist {
    class Solution {
        int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean[][] visited = new boolean[m][n];
                        if (dfs(board, word, 0, i, j, visited)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
            // 边界检查 + 字符匹配检查
            if (idx == word.length()) return true;
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                    || visited[i][j] || board[i][j] != word.charAt(idx)) {
                return false;
            }

            visited[i][j] = true;

            // 四个方向搜索
            for (int[] d : dir) {
                if (dfs(board, word, idx + 1, i + d[0], j + d[1], visited)) {
                    return true;
                }
            }

            visited[i][j] = false;  // 回溯
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
