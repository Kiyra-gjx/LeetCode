package hot100;

public class t73setZeroes {
    static class Solution {
        public void setZeroes(int[][] matrix) {
            int rowHasZero = 0;
            int colHasZero = 0;
            int n = matrix.length;
            int m = matrix[0].length;
            for (int j = 0; j < m; j++) {
                if (matrix[0][j] == 0) {
                    rowHasZero = 1;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) {
                    colHasZero = 1;
                    break;
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (rowHasZero == 1) {
                for (int i = 0; i < m; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (colHasZero == 1) {
                for (int i = 0; i < n; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
