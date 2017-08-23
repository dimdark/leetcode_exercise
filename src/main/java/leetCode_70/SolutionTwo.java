package leetCode_70;

/**
 * @author dimdark
 * @date 2017-08-23
 * @time 9:27 AM
 */
public class SolutionTwo {

    // optize space store
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int first, medium, end;
        first = 1; medium = end = 2;
        for(int i = 3; i <= n; ++i) {
            end = first + medium;
            first = medium;
            medium = end;
        }
        return end;
    }

}
