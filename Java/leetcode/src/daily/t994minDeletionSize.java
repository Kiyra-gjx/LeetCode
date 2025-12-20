package daily;

public class t994minDeletionSize {
}

class t994Solution {
    public int minDeletionSize(String[] strs) {
        if (strs.length == 1) {
            return 0;
        }
        int ans = 0;
        for (int idx = 0; idx < strs[0].length(); idx++) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(idx) > strs[i + 1].charAt(idx)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
