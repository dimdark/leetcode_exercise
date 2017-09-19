package leetCode_516;

/**
 * 求最长回文子序列
 * @author dimdark
 * @date 2017-09-19
 * @time 7:45 AM
 */
public class SolutionTwo {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s == "") return 0;
        String r = (new StringBuilder(s)).reverse().toString();
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; ++i) {
            for (int j = 1; j <= len; ++j) {
                if (s.charAt(i-1) == r.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[len][len];
    }

}
