package leetCode_17;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-08-25
 * @time 10:45 AM
 */
public class SolutionTwo {

    private static String[] KEY_MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<String>();
        if(digits.length() == 0) return list;
        String prefix, letters;
        list.add("");
        for(int i = 0; i < digits.length(); ++i) { // bfs
            letters = KEY_MAP[Character.getNumericValue(digits.charAt(i))];
            while(list.peek().length() == i) { // wonderful
                prefix = list.remove();
                for(int j = 0; j < letters.length(); ++j) {
                    list.add(prefix + letters.charAt(j));
                }
            }
        }
        return list;
    }

}
