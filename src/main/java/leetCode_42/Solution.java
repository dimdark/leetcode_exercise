package leetCode_42;

/**
 * @author dimdark
 */
public class Solution {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int maxLeft, maxRight;
        for (int i = 1; i < height.length - 1; ++i) {
            maxLeft = maxRight = 0;
            for (int j = 0; j <= i; ++j) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < height.length; ++j) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

}
