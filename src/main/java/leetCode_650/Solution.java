package leetCode_650;

/**
 * @author dimdark
 * @date 2017-09-13
 * @time 8:26 PM
 */
public class Solution {

    public int minSteps(int n) {
        int[] rst = new int[n+1];
        int i, j;
        rst[1] = 0;
        for (i = 2; i <= n; ++i) {
            boolean isPrime = true;
            for (j = i/2; j > 1; --j) {
                if (i % j == 0) {
                    isPrime = false; break;
                }
            }
            if (!isPrime) {
                rst[i] = rst[j] + i/j;
            } else { // is prime
                rst[i] = i;
            }
        }
        return rst[n];
    }

}
