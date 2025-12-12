package hot100;

import java.util.ArrayList;
import java.util.List;

public class t118generate {
}

class t118Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> layer = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    layer.add(1);
                } else {
                    layer.add(ans.getLast().get(j - 1) + ans.getLast().get(j));
                }
            }
            ans.add(layer);
        }

        return ans;
    }
}


