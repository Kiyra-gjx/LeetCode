package hot100;

public class t48rotate {
    static class Solution {
        public void rotate(int[][] matrix) {
            for (int cnt = 0; cnt < matrix.length / 2; cnt++) {
                int n = matrix.length - 2 * cnt;
                for (int i = 0; i < n - 1; i++) {
                    int temp = matrix[cnt][cnt + i];
                    matrix[cnt][cnt + i] = matrix[cnt + n - 1 - i][cnt];
                    matrix[cnt + n - 1 - i][cnt] = matrix[cnt + n - 1][cnt + n - 1 - i];
                    matrix[cnt + n - 1][cnt + n - 1 - i] = matrix[cnt + i][cnt + n - 1];
                    matrix[cnt + i][cnt + n - 1] = temp;
                }
            }
        }
    }
}
