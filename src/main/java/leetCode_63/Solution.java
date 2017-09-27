package leetCode_63;

/**
 * @author dimdark
 * @date 2017-09-27
 * @time 4:31 PM
 */
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] != 1) {
                    if (i != 0 && j != 0) {
                        dp[j] += dp[j - 1];
                    } else if (i == 0 && j != 0) {
                        dp[j] = dp[j - 1];
                    } else if (i != 0 && j == 0) {
                        dp[j] = dp[j];
                    } else {
                        dp[j] = 1;
                    }
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[m - 1];
    }

}
