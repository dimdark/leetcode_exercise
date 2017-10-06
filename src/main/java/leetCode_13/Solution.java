package leetCode_13;

import java.util.HashMap;

/**
 * @author dimdark
 * @date 2017-10-06
 * @time 4:53 PM
 */
public class Solution {

    private static HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();

    private static final String ROMAN_STRING = "IVXLCDM";

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        int rst = romanMap.get(cs[cs.length - 1]);
        int i = cs.length - 2, j = cs.length - 1;
        while (i >= 0) { // O(n)
            int idx1 = ROMAN_STRING.indexOf(cs[i]);
            int idx2 = ROMAN_STRING.indexOf(cs[j]);
            if (idx1 >= idx2) {
                rst += romanMap.get(cs[i]);
            } else {
                rst -= romanMap.get(cs[i]);
            }
            --i; --j;
        }
        return rst;
    }

}
