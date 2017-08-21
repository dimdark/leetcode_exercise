package leetCode_343;

import java.util.Arrays;

/**
 * 递推解法
 * @author dimdark
 * @date 2017-08-20
 * @time 11:55 PM
 */
public class Solution {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        int maxValue;
        Arrays.fill(dp, 0);
        for(int i = 2; i <= n; ++i) {
            maxValue = Integer.MIN_VALUE;
            for(int j = 1; j <= (i / 2); ++j) {
                dp[i] = Integer.max(j, dp[j]) * Integer.max(i - j, dp[i - j]);
                maxValue = (dp[i] > maxValue) ? dp[i] : maxValue;
            }
            dp[i] = maxValue;
        }
        return dp[n];
    }

}
