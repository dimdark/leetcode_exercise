package leetCode_53;

/**
 * @author dimdark
 * @date 2017-10-01
 * @time 1:09 PM
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        int maxSubarraySum = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; ++i) {
            dp[i] = nums[i - 1] + (dp[i - 1] <= 0 ? 0 : dp[i - 1]);
            maxSubarraySum = Integer.max(dp[i], maxSubarraySum);
        }
        return maxSubarraySum;
    }

}
