package daily;

public class t955minDeletionSize {
}

class t955Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int size = n - 1;
        int[] check = new int[size];
        for (int i = 0; i < size; i++) {
            check[i] = i;
        }

        int ans = 0;
        next:
        for (int j = 0; j < m; j++) {
            for (int t = 0; t < size; t++) {
                int i = check[t];
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    ans++;
                    continue next;
                }
            }

            int newSize = 0;
            for (int t = 0; t < size; t++) {
                int i = check[t];
                if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                    check[newSize++] = i;
                }
            }

            size = newSize;
        }

        return ans;
    }
}
