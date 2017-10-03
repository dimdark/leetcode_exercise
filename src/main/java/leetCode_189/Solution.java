package leetCode_189;

/**
 * @author dimdark
 * @date 2017-10-03
 * @time 7:29 PM
 */
public class Solution {

    private void reverse(int[] nums, int i, int j) {
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            ++i;
            --j;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        if (k >= nums.length) {
            k %= nums.length;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

}
