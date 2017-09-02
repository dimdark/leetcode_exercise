package leetCode_575;

import java.util.HashSet;

/**
 * @author dimdark
 * @date 2017-09-02
 * @time 9:33 AM
 */
public class SolutionTwo {

    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<Integer>(210000, 0.75f);
        int len = candies.length;
        for(int i = 0; i < len; ++i) {
            set.add(candies[i]);
        }
        return Integer.min(set.size(), len>>1);
    }

}
