package leetCode_55;

/**
 * @author dimdark
 * @date 2017-09-06
 * @time 9:27 AM
 */
public class Solution {

    public boolean canJump(int[] nums) {
        if (nums ==  null || nums.length == 0) return false;
        int maxReach = 0;
        for (int i = 0; i < nums.length && i <= maxReach; ++i) {
            maxReach = Integer.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length-1;
    }

}
