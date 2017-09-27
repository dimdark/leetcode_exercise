package leetCode_44;

/**
 * @author dimdark
 * @date 2017-09-27
 * @time 10:55 PM
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        char[] cs = s.toCharArray();
        int sLen = cs.length;
        char[] cp = p.toCharArray();
        int pLen = 0;
        // omit duplicated '*'
        for (int i = 0; i < cp.length; ++i) {
            if(i > 0 && cp[i] == '*' && cp[i - 1] == '*') continue;
            cp[pLen++] = cp[i];
        }
        boolean[] dp = new boolean[pLen + 1];
        dp[0] = true;
        for (int i = 1; i <= pLen; ++i) {
            dp[i] = (cp[i - 1] == '*') && dp[i - 1]; // dp[i] = (cp[i - 1] == '*') ? dp[i - 1] : false;
        }
        boolean preValue = false, tmpValue;
        for (int i = 1; i <= sLen; ++i) {
            for (int j = 0; j <= pLen; ++j) {
                if (j != 0) {
                    if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '?') {
                        tmpValue = dp[j];
                        dp[j] = preValue;
                        preValue = tmpValue;
                    } else if (cp[j - 1] == '*') {
                        preValue = dp[j];
                        dp[j] = dp[j - 1] || dp[j];
                    } else {
                        preValue = dp[j];
                        dp[j] = false;
                    }
                } else {
                    preValue = dp[0];
                    dp[0] = false;
                }
            }
        }
        return dp[pLen];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "*"));
    }

}
