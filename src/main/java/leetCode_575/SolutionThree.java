package leetCode_575;

/**
 * @author dimdark
 * @date 2017-09-02
 * @time 9:46 AM
 */
public class SolutionThree {

    public int distributeCandies(int[] candies) {
        int[] buckets = new int[200000 + 1];
        int len = candies.length, kinds = 0;
        for (int i = 0; i < len; ++i) {
            buckets[100000 + candies[i]]++;
        }
        for (int i = 0; i < buckets.length; ++i) {
            if(buckets[i] != 0) kinds++;
        }
        return Integer.min(kinds, len>>1);
    }

}
