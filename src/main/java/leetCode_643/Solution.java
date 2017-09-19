package leetCode_643;

/**
 * @author dimdark
 * @date 2017-09-19
 * @time 9:24 AM
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int start = 0, end = k - 1;
        long subSum = 0, maxSum = 0;
        for (int i = start; i <= end; ++i) {
            subSum += nums[i];
        }
        maxSum = subSum;
        while (end < nums.length -1) {
            subSum = subSum - nums[start] + nums[end + 1];
            maxSum = (maxSum < subSum) ? subSum : maxSum;
            ++start; ++end;
        }
        return (double)maxSum / k;
    }

}
