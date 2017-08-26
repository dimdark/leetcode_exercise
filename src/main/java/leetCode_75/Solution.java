package leetCode_75;

/**
 * @author dimdark
 * @date 2017-08-26
 * @time 10:22 AM
 */
public class Solution {

    public void sortColors(int[] nums) {
        int zeroCnt, oneCnt, twoCnt;
        zeroCnt = oneCnt = twoCnt = 0;
        for(int i = 0; i < nums.length; ++i) { // first pass
            if(nums[i] == 0) zeroCnt++;
            else if(nums[i] == 1) oneCnt++;
            else twoCnt++;
        }
        for(int i = 0; i < nums.length; ++i) { // second pass
            if(i < zeroCnt) nums[i] = 0;
            else if(zeroCnt <= i && i < zeroCnt+oneCnt) nums[i] = 1;
            else nums[i] = 2;
        }
    }

}
