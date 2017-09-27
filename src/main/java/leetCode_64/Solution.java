package leetCode_64;

/**
 * @author dimdark
 * @date 2017-09-27
 * @time 4:49 PM
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return -1; // im-possible case
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i != 0 && j != 0) {
                    dp[j] = Integer.min(dp[j], dp[j - 1]) + grid[i][j];
                } else if (i == 0 && j != 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (i != 0 && j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[m - 1];
    }

}
