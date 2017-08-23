package leetCode_70;

/**
 * @author dimdark
 * @date 2017-08-23
 * @time 9:07 AM
 */
public class Solution {

    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] a = new int[n+1];
        a[1] = 1;
        a[2] = 2;
        for(int i = 3; i <= n; ++i) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

}
