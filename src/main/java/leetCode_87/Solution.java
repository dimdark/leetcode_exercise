package leetCode_87;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author dimdark
 * @date 2017-09-27
 * @time 1:24 PM
 */
public class Solution {

    private HashMap<String, Boolean> map = new HashMap<String, Boolean>();

    private boolean scrambled(String s1, String s2, int i, int j, int len) {
        String key = Arrays.toString(new int[] {i, j, len});
        if (map.containsKey(key)) return map.get(key);
        if (len == 1) {
            boolean rst = s1.charAt(i) == s2.charAt(j);
            map.put(key, rst);
            return rst;
        }
        for (int subLen = 1; subLen < len; ++subLen) {
            if (scrambled(s1, s2, i, j, subLen) &&
                    scrambled(s1, s2, i + subLen, j + subLen, len - subLen)) {
                map.put(key, true);
                return true;
            }
            if (scrambled(s1, s2, i, j + len - subLen, subLen) &&
                    scrambled(s1, s2, i + subLen, j, len - subLen)) {
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        return scrambled(s1, s2, 0, 0, s1.length());
    }

}
