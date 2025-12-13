package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class t3606validateCoupons {
}

class t3606Solution {
    public boolean check(String code, boolean isActive) {
        for (char it : code.toCharArray()) {
            if (it != '_' && !Character.isLetterOrDigit(it)) {
                return false;
            }
        }
        return isActive;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>[] group = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            group[i] = new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            if (!code[i].isEmpty() && check(code[i], isActive[i])) {
                switch (businessLine[i]) {
                    case "electronics" -> group[0].add(code[i]);
                    case "grocery" -> group[1].add(code[i]);
                    case "pharmacy" -> group[2].add(code[i]);
                    case "restaurant" -> group[3].add(code[i]);
                }
            }
        }

        for (List<String> layer : group) {
            Collections.sort(layer);
            ans.addAll(layer);
        }

        return ans;
    }
}
