package leetCode_42;

/**
 * @author dimdark
 */
public class SolutionFour {

    public int trap(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int ans = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            if (minHeight == heights[left]) {
                while (++left < right && heights[left] < minHeight) {
                    ans += minHeight - heights[left];
                }
            } else {
                while (--right > left && heights[right] < minHeight) {
                    ans += minHeight - heights[right];
                }
            }
        }
        return ans;
    }

}
