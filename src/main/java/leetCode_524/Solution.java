package leetCode_524;

import java.util.List;

/**
 * @author dimdark
 * @date 2017-09-20
 * @time 8:01 PM
 */
public class Solution {

    public String findLongestWord(String s, List<String> d) { // O(n^2)
        String maxSubString = "";
        int maxSubLen = 0;
        char[] cs, cw;
        cs = s.toCharArray();
        for (String w : d) { // w : word
            cw = w.toCharArray();
            int i = 0, j = 0;
            while (i < cs.length && j < cw.length) {
                if (cs[i] == cw[j]) ++j;
                ++i;
            }
            if (j >= cw.length) { // sub sequence
                if (maxSubLen < cw.length || (maxSubLen == cw.length && maxSubString.compareTo(w) > 0)) {
                    maxSubLen = cw.length;
                    maxSubString = w;
                }
            }
        }
        return maxSubString;
    }

}
