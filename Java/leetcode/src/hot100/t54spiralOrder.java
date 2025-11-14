package hot100;

import java.util.ArrayList;
import java.util.List;

public class t54spiralOrder {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int[][] face = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
            int i = 0, j = 0, nxt = 0, cnt = 0;
            List<Integer> ans = new ArrayList<>();
            while(true){
                boolean flag = false;
                while (((i + face[nxt][0] >= matrix.length || i + face[nxt][0] < 0)
                        || (j + face[nxt][1] >= matrix[0].length || j + face[nxt][1] < 0))
                        || matrix[i + face[nxt][0]][j + face[nxt][1]] == 101) {
                    cnt++;
                    if (cnt == 4) {
                        flag = true;
                        break;
                    }
                    nxt = (nxt + 1) % 4;
                }
                ans.add(matrix[i][j]);
                if(flag){
                    break;
                }
                cnt = 0;
                matrix[i][j] = 101;
                i += face[nxt][0];
                j += face[nxt][1];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(s.spiralOrder(matrix));
    }
}
