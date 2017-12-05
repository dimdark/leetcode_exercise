package leetCode_42;

import java.util.Stack;

/**
 * @author dimdark
 */
public class SolutionThree {

    public int trap(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int right = 0;
        while (right < heights.length) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[right]) {
                int idx = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                ans += (right - left - 1) * (Math.min(heights[left], heights[right]) - heights[idx]);
            }
            stack.push(right++);
        }
        return ans;
    }

}
