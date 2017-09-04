package leetCode_523;

import java.util.HashSet;

/**
 * @author dimdark
 * @date 2017-09-04
 * @time 8:25 PM
 */
public class SolutionTwo {

    // T(i, j) = S(j), i=1 ---> T(i, j) = S(j) = n*k
    // T(i, j) = S(j) - S(i-1), i>1 ---> S(j)%k = S(i-1)%k
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        boolean expected = false;
        int preRemainder = 0, curRemainder = 0;
        for (int i = 0; i < nums.length; ++i) {
            curRemainder += nums[i];
            curRemainder = (k==0) ? curRemainder : (curRemainder%k);
            if (set.contains(curRemainder)) { // must at least 2
                expected = true; break;
            }
            set.add(preRemainder);
            preRemainder = curRemainder;
        }
        return expected;
    }

}
