package leetCode_32;

import java.util.Stack;

/**
 * @author dimdark
 * @date 2017-10-01
 * @time 7:40 PM
 */
public class Solution {

    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        Stack<Integer> stk = new Stack<Integer>();
        int maxLen = 0, leftBound = -1, len = s.length();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                if (!stk.empty()) {
                    stk.pop();
                    maxLen = Integer.max(maxLen, i - (stk.empty() ? leftBound : stk.peek()));
                } else {
                    leftBound = i; // update
                }
            }
        }
        return maxLen;
    }

}
