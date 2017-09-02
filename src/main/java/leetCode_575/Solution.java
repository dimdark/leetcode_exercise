package leetCode_575;

import java.util.HashMap;

/**
 * @author dimdark
 * @date 2017-09-02
 * @time 9:27 AM
 */
public class Solution {

    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(210000, 0.75f);
        int len = candies.length;
        for (int i = 0; i < len; ++i) {
            map.put(candies[i], 1);
        }
        return Integer.min(map.size(), len>>1);
    }

}
