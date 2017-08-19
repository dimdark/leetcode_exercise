package leetCode_11;

/**
 * @author dimdark
 * @date 2017-05-03
 * @time 12:48 PM
 */
public class Solution {

    public int maxArea(int[] h){
        int start = 0,end = h.length-1;
        int maxAreaValue = 0,areaValue;
        while (start<end){
            areaValue = Math.min(h[start],h[end])*(end-start);
            maxAreaValue = (maxAreaValue<areaValue)?areaValue:maxAreaValue;
            if(h[start]<=h[end]){
                ++start;
            }else {
                --end;
            }
        }
        return maxAreaValue;
    }

}
