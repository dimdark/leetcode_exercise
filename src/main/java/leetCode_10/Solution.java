package leetCode_10;

/**
 * @author dimdark
 * @date 2017-10-01
 * @time 8:43 PM
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sLen = s.length(), pLen = p.length();
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // initial
        dp[0][0] = true;
        for (int i = 1; i <= pLen; ++i) {
//            dp[0][i] = (cp[i - 1] == '*') ? dp[0][i - 2] : false;
            dp[0][i] = (cp[i - 1] == '*') && dp[0][i - 2];
        }
        for (int i = 1; i <= sLen; ++i) {
            for (int j = 0; j <= pLen; ++j) {
                if (j != 0) {
                    if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if(cp[j - 1] == '*') {
                        dp[i][j] = dp[i][j - 2];
                        if (!dp[i][j] && (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.')) {
                            dp[i][j] = dp[i - 1][j];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[sLen][pLen];
    }

}
