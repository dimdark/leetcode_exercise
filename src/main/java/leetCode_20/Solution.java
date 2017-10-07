package leetCode_20;

import java.util.Stack;

/**
 * @author dimdark
 * @date 2017-10-07
 * @time 3:21 PM
 */
public class Solution {

    public boolean isValid(String s) {
        if (s == null) return false;
        Stack<Character> stk = new Stack<Character>();
        boolean rst = true;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == '(' || cs[i] == '[' || cs[i] == '{') {
                stk.push(cs[i]);
            } else {
                if (stk.empty()) {
                    rst = false; break;
                }
                char ch = stk.peek();
                if ((cs[i] == ')' && ch != '(') || (cs[i] == ']' && ch != '[')
                        || (cs[i] == '}' && ch != '{')) {
                    rst = false; break;
                }
                stk.pop();
            }
        }
        if (!stk.empty()) {
            rst = false;
        }
        return rst;
    }

}
