package leetCode_97;

/**
 * @author dimdark
 * @date 2017-09-05
 * @time 8:25 PM
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len3 != len1 + len2) return false;
        boolean[] dp = new boolean[len2 + 1];
        for (int i = 0; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = (s2.charAt(j-1) == s3.charAt(i+j-1)) && dp[j-1];
                } else if (j == 0) {
                    dp[0] = (s1.charAt(i-1) == s3.charAt(i+j-1)) && dp[0];
                } else {
                    dp[j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[j-1]);
                }
            }
        }
        return dp[len2];
    }

}
