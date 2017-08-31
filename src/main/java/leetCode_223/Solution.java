package leetCode_223;

/**
 * @author dimdark
 * @date 2017-08-31
 * @time 7:51 PM
 */
public class Solution {

    public int computeArea(int aX, int aY, int bX, int bY, int cX, int cY, int dX, int dY) {
        int left = Integer.max(aX, cX), right = Integer.max(Integer.min(bX, dX), left);
        int bottom = Integer.max(aY, cY), top = Integer.max(Integer.min(bY, dY), bottom);
        return (bX-aX)*(bY-aY) + (dX-cX)*(dY-cY) - (right-left)*(top-bottom);
    }

}
