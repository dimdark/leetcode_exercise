package leetCode_396;

/**
 * @author dimdark
 * @date 2017-09-06
 * @time 9:12 PM
 */
public class Solution {

    public int maxRotateFunction(int[] a) {
        if ( a == null || a.length == 0) return 0;
        int sum = 0, n = a.length;
        int preValue = 0, curValue;
        for (int i = 0; i < n; ++i) {
            preValue += i * a[i];
            sum += a[i];
        }
        int maxValue = preValue;
        for (int i = 1; i < n; ++i) {
            curValue = preValue + sum - a[n-i]*n;
            maxValue = (maxValue >= curValue) ? maxValue : curValue;
            preValue = curValue;
        }
        return maxValue;
    }

}
