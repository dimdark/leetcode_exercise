package leetCode_33;

/**
 * @author dimdark
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minIdx = findMinIndex(nums); // steps of moving
        int low = 0;
        int high = nums.length - 1;
        int mid, realMid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            realMid = (mid + minIdx) % nums.length; // map to real index
            if (nums[realMid] == target) {
                return realMid;
            } else if (nums[realMid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
