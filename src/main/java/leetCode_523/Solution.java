package leetCode_523;

/**
 * @author dimdark
 * @date 2017-09-04
 * @time 8:06 PM
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int len = nums.length;
        boolean expected = false;
        for (int i = 1; i < len; ++i) {
            int ans = nums[i];
            for (int j = i-1; j >= 0; --j) {
                ans += nums[j];
                if ((k == 0 && ans == 0) || (k != 0 && ans % k == 0)) {
                    expected = true; break;
                }
            }
            if (expected) break;
        }
        return expected;
    }

}
