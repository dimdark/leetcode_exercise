package leetCode_17;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-08-25
 * @time 9:51 AM
 */
public class Solution {

    private static String[] KEY_MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> l = new LinkedList<String>();
        if(digits.length() == 0) return l;
        combinations(new StringBuilder(), digits, 0, l);
        return l;
    }

    private void combinations(StringBuilder prefix, String digits, int offset, List<String> list) {
        if(offset >= digits.length()) {
            list.add(prefix.toString());
            return ;
        }
//        System.out.println(digits.charAt(offset));
        String letters = KEY_MAP[digits.charAt(offset) - '0'];
        for(int i = 0; i < letters.length(); ++i) {
            prefix.append(letters.charAt(i)); offset++; // add
            combinations(prefix, digits, offset, list);
            prefix.deleteCharAt(prefix.length()-1); offset--;// cancel
        }
    }

}
