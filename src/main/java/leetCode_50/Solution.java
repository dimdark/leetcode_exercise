package leetCode_50;

/**
 * @author dimdark
 */
public class Solution {

    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            throw new ArithmeticException("x and n shouldn't be zero at the same time!");
        }
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1.0;
        }
        boolean flag = n > 0;
        n = Math.abs(n);
        double ans = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return flag ? ans : 1.0 / ans;
    }

}
