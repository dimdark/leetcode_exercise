package leetcode_274;

import java.util.Arrays;

/**
 * O(nlogn)解法
 * @author dimdark
 * @date 2017-08-24
 * @time 9:58 AM
 */
public class Solution {

    public int hIndex(int[] citations) {
        int cnt = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; ++i) {
            if(citations[i] >= cnt) break;
            cnt--;
        }
        return cnt;
    }

}
