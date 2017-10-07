package leetCode_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-10-07
 * @time 4:40 PM
 */
public class Solution {

    // lst bs bPairSum lBracketCnt rBracketCnt
    private void helper(List<String> list, char[] brackets,
                        final int bracketPairSum, int leftBracketCnt, int rightBracketCnt) {
        if (leftBracketCnt + rightBracketCnt >= bracketPairSum * 2) {
            String s = new String(brackets);
            list.add(s);
            return;
        }
        int idx = leftBracketCnt + rightBracketCnt;
        if (leftBracketCnt < bracketPairSum) {
            brackets[idx] = '(';
            helper(list, brackets, bracketPairSum, leftBracketCnt + 1, rightBracketCnt);
        }
        if (rightBracketCnt < leftBracketCnt) {
            brackets[idx] = ')';
            helper(list, brackets, bracketPairSum, leftBracketCnt, rightBracketCnt + 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        if (n == 0) return rst;
        char[] cs = new char[n << 1];
        helper(rst, cs, n, 0, 0);
        return rst;
    }

}
