package leetCode_438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-08-28
 * @time 12:16 PM
 */
public class SolutionTwo {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<Integer>();
        if(s==null || s.length()<p.length()) return rst;
        int[] map = new int[26];
        for(char c : p.toCharArray()) map[c-97]++;
        int head, tail,sLen, pLen, counter;
        head = tail = 0;
        sLen = s.length();
        pLen = counter = p.length();
        while(tail < sLen) {
            if(map[s.charAt(tail++)-97]-- > 0) counter--;
            while(counter == 0) { // find the satisfied case
                if(tail - head == pLen) rst.add(head);
                if(map[s.charAt(head++)-97]++ == 0) counter++;
            }
        }
        return rst;
    }

}
