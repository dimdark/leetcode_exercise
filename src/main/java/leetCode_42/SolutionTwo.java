package leetCode_42;

/**
 * @author dimdark
 */
public class SolutionTwo {

    public int trap(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] maxLefts = new int[heights.length];
        int[] maxRights = new int[heights.length];
        maxLefts[0] = heights[0];
        for (int i = 1; i < maxLefts.length; ++i) {
            maxLefts[i] = Math.max(maxLefts[i - 1], heights[i]);
        }
        maxRights[maxRights.length - 1] = heights[heights.length - 1];
        for (int i = maxRights.length - 2; i >= 0; --i) {
            maxRights[i] = Math.max(maxRights[i + 1], heights[i]);
        }
        for (int i = 1; i < heights.length - 1; ++i) {
            ans += Math.min(maxLefts[i], maxRights[i]) - heights[i];
        }
        return ans;
    }

}
