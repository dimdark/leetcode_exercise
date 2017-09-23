package leetCode_115;

/**
 * @author dimdark
 * @date 2017-09-23
 * @time 10:57 AM
 */
public class Solution {

    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;// im-possible case
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] dp = new int[cs.length + 1];
        // initial
        dp[0] = 1;
        for (int i = 1; i <= cs.length ; ++i) {
            dp[i] = 0;
        }
        int preSum = 0, tmpValue;
        for (int i = 1; i <= ct.length; ++i) {
            for (int j = 0; j <= cs.length; ++j) {
                if (j != 0) {
                    tmpValue = dp[j];
                    dp[j] = (ct[i-1] == cs[j-1]) ? preSum : 0;
                    preSum += tmpValue;
                } else {
                    dp[j] = 0;
                    preSum = (i != 1) ? 0 : 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i <= cs.length; ++i) {
            cnt += dp[i];
        }
        return cnt;
    }

}
