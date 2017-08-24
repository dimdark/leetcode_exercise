package leetCode_275;

/**
 * @author dimdark
 * @date 2017-08-24
 * @time 10:22 AM
 */
public class Solution {

    public int hIndex(int[] citations) {
        int cnt = citations.length;
        for(int i = 0; i < citations.length; ++i) {
            if(citations[i] >= cnt) break;
            cnt--;
        }
        return cnt;
    }

}
