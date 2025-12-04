package hot100;

public class t74searchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int leftRow = 0, rightRow = matrix.length - 1;
            int leftCol = 0, rightCol = matrix[0].length - 1;

            int row = -1;
            while(leftRow <= rightRow) {
                int mid = (leftRow + rightRow) / 2;
                if (target >= matrix[mid][leftCol] && target <= matrix[mid][rightCol]) {
                    row = mid;
                    break;
                } else if (target < matrix[mid][leftCol]) {
                    rightRow = mid - 1;
                } else {
                    leftRow = mid + 1;
                }
            }
            if (row == -1) {
                return false;
            }

            while(leftCol <= rightCol) {
                int mid = (leftCol + rightCol) / 2;
                if (target == matrix[row][mid]) {
                    return true;
                } else if (target < matrix[row][mid]) {
                    rightCol = mid - 1;
                } else {
                    leftCol = mid + 1;
                }
            }

            return false;
        }
    }
}
