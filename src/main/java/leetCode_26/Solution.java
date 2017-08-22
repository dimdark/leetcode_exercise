package leetCode_26;

/**
 * @author dimdark
 * @date 2017-08-22
 * @time 8:39 AM
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int newLen = 1;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] != nums[newLen-1]) {
                nums[newLen++] = nums[i];
            }
        }
        return newLen;
    }

}
