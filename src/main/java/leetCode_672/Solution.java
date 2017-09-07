package leetCode_672;

/**
 * @author dimdark
 * @date 2017-09-07
 * @time 9:52 PM
 */
public class Solution {

    public int flipLights(int n, int m) {
        if (n >= 3) {
            if (m >= 3) return 8;
            else if (m == 2) return 7;
            else if (m == 1) return 4;
            else return 1;
        } else if (n == 2) {
            if (m >= 2) return 4;
            else if (m == 1) return 3;
            else return 1;
        } else if (n == 1) {
            if (m >= 1) return 2;
            else return 1;
        } else {
            return 0;
        }
    }

}
