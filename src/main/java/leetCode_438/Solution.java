package leetCode_438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-08-27
 * @time 10:35 PM
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<Integer>();
        if(s==null || s.length()<p.length()) return rst;
        int sLen = s.length(), pLen = p.length(), i, j;
        int[] charCnt = new int[26];
        int[] tempCnt = new int[26];
        for(i = 0; i < pLen; ++i) {
            charCnt[p.charAt(i)-97]++;
            tempCnt[s.charAt(i)-97]++;
        }
        for(i = 0; i < sLen-pLen+1; ++i) {
            for(j = 0; j < 26; ++j) {
                if(charCnt[j] != tempCnt[j]) break;
            }
            if(j >= 26) rst.add(i);
            if(i+pLen >= sLen) break;
            tempCnt[s.charAt(i)-97]--;tempCnt[s.charAt(i+pLen)-97]++;
        }
        return rst;
    }

}
