package leetCode_153;

/**
 * @author dimdark
 * @date 2017-08-29
 * @time 9:56 AM
 */
public class Solution {

    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] < nums[nums.length-1]) return nums[0];
        int left = 0, right = nums.length-1, mid; // initial
        while(left < right) {
            if(nums[left] < nums[right]) break; // sorted array, non-rotated array
            mid = left + ((right-left)>>1);
            if(nums[left] <= nums[mid]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

}
