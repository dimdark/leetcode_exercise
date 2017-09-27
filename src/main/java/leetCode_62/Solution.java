package leetCode_62;

/**
 * @author dimdark
 * @date 2017-09-27
 * @time 1:42 PM
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[j] = (i != 0 && j != 0) ? (dp[j - 1] + dp[j]) : 1;
            }
        }
        return dp[n - 1];
    }

}
