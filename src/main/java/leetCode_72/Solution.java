package leetCode_72;

/**
 * @author dimdark
 * @date 2017-09-22
 * @time 3:09 PM
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1; // not possible operation
        int len1 = word1.length(), len2 = word2.length();
        int[] dp = new int[len2 + 1];
        for (int i = 0; i <= len2; ++i) { // initial
            dp[i] = i;
        }
        int preValue = -1, tmpValue; // save the lastest value that was replaced
        for (int i = 1; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) {
                if (j != 0) {
                    tmpValue = dp[j]; // save the value that will change at soon
                    dp[j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? preValue :
                            Integer.min(preValue, Integer.min(dp[j-1], dp[j])) + 1;
                    preValue = tmpValue; // update preValue
                } else {
                    preValue = dp[j];
                    dp[j] = i;
                }
            }
        }
        return dp[len2];
    }

}
