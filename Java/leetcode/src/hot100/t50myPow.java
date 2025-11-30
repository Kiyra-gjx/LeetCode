package hot100;

public class t50myPow {
    class Solution {
        public double myPow(double x, int n) {
            long exponent = n;
            boolean isPositive = exponent > 0;
            exponent = Math.abs(exponent);
            double ans = 1.0;
            while(exponent > 0) {
                if (exponent % 2 == 1) {
                    ans = ans * x;
                }
                exponent >>= 1;
                x = x * x;
            }
            return isPositive ? ans : 1 / ans;
        }
    }
}
