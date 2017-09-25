package leetCode_646;

import java.util.Arrays;

/**
 * @author dimdark
 * @date 2017-09-25
 * @time 10:33 PM
 */
public class Solution {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (pairA, pairB) -> (pairA[1] > pairB[1]) ? 1 : (pairA[1] == pairB[1]) ? 0 : -1);
        int i, j;
        int count = 0;
        for (i = 0, j = 0; j < pairs.length; ++j) {
            if (j == 0 || pairs[i][1] < pairs[j][0]) {
                ++count;
                i = j;
            }
        }
        return count;
    }

}
