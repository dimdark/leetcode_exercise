package leetCode_27;

/**
 * @author dimdark
 * @date 2017-09-15
 * @time 4:27 PM
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int step = 0;
        for (int i = 0; i < nums.length; ++i) { // O(n)
            if (nums[i] == val) ++step;
            else nums[i - step] = nums[i];
        }
        return nums.length - step;
    }

}
