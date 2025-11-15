package hot100;

public class t240searchMatrix {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0, j = 0;
            for (i = 0, j = 0; i < m && j < n;) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    if (i == m - 1 && j == n - 1) {
                        break;
                    } else if (j == n - 1) {
                        i++;
                    } else if (i == m - 1) {
                        j++;
                    } else {
                        i++;
                        j++;
                    }
                } else {
                    i = Math.max(i - 1, 0);
                    j = Math.max(j - 1, 0);
                    break;
                }
            }
            for (int x = i + 1; x < m; x++) {
                for (int y = 0; y <= j; y++) {
                    if (matrix[x][y] == target) {
                        return true;
                    }
                }
            }
            for (int x = 0; x <= i; x++) {
                for (int y = j + 1; y < n; y++) {
                    if (matrix[x][y] == target) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {11, 13, 15, 17, 19},
                {12, 14, 16, 18, 20},
                {21, 22, 23, 24, 25}
        };
        int target = 11;
        System.out.println(s.searchMatrix(matrix, target)); // true
    }
}
