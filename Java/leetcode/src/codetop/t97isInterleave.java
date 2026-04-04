package codetop;

public class t97isInterleave {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        t97Solution t = new t97Solution();
        System.out.println(t.isInterleave(s1, s2, s3));
    }
}

class t97Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 < n2) {
            return isInterleave(s2, s1, s3);
        }

        if (n1 + n2 != s3.length()) {
            return false;
        }

        int idx1= 0, idx2 = 0;
        int idx = 0;
        while(idx1 < n1 && idx2 < n2) {
            if (s3.charAt(idx) == s1.charAt(idx1)) {
                idx1++;
                idx++;
            } else if (s3.charAt(idx) == s2.charAt(idx2)) {
                idx2++;
                idx++;
            } else {
                return false;
            }
        }

        return s3.substring(idx).equals(s1.substring(idx1));
    }
}
