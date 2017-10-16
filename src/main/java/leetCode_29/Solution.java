package leetCode_29;

/**
 * @author dimdark
 * @date 2017-10-16
 * @time 2:35 PM
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor can not be zero!");
        }
        if (dividend == 0) {
            return 0;
        }
        // handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // handle sign
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        long newDividend = Math.abs(Integer.valueOf(dividend).longValue());
        long newDivisor = Math.abs(Integer.valueOf(divisor).longValue());
        long times = 0, tmpTimes, tmpValue;
        while (newDividend >= newDivisor) {
            tmpValue = newDivisor;
            tmpTimes = 1;
            while (newDividend >= (tmpValue << 1)) {
                tmpTimes <<= 1; // * 2
                tmpValue <<= 1; // * 2
            }
            newDividend -= tmpValue;
            times += tmpTimes;
        }
        if (sign == -1) times = -times;
        return Long.valueOf(times).intValue();
    }

}
