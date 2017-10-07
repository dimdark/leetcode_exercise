package leetCode_20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author dimdark
 * @date 2017-10-07
 * @time 3:30 PM
 */
public class SolutionTwo {

    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<Character>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == '(' || cs[i] == '[' || cs[i] == '{') {
                stk.push(cs[i]);
            } else {
                if (stk.isEmpty()) {
                    return false;
                }
                char ch = stk.peek();
                if ((cs[i] == ')' && ch != '(') || (cs[i] == ']' && ch != '[')
                        || (cs[i] == '}' && ch != '{')) {
                    return false;
                }
                stk.pop();
            }
        }
        return stk.isEmpty();
    }

}
