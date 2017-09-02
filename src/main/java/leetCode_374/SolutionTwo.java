package leetCode_374;

/**
 * @author dimdark
 * @date 2017-09-02
 * @time 8:58 AM
 */
public class SolutionTwo {

    public int guessNumber(int n) {
        int left = 1, right = n, mid, rst;
        while(left < right) {
            mid = left + ((right-left)>>1);
            rst = guess(mid);
            if(rst == 1) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int guess(int mid) {
        return -1;
    }

}
