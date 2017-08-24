package leetcode_274;

/**
 * @author dimdark
 * @date 2017-08-24
 * @time 10:05 AM
 */
public class SolutionTwo {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for(int i = 0; i < citations.length; ++i) {
            if(citations[i] >= n) bucket[n]++;
            else bucket[citations[i]]++;
        }
        int cnt = 0;
        for(int i = n; i >= 0; --i) {
            cnt += bucket[i];
            if(cnt >= i) return i;
        }
        return 0;
    }

}
