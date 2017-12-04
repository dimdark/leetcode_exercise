package leetCode_45;

/**
 * @author dimdark
 */
public class Solution {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums is null or its length is equal to zero!");
        }
        int targetIdx = nums.length - 1;
        int step = 0;
        while (targetIdx != 0) {
            int idx = 0;
            while (nums[idx] - (targetIdx - idx) < 0) {
                ++idx;
            }
            if (idx == targetIdx) {
                throw new RuntimeException("can't jump to the end!");
            }
            ++step;
            targetIdx = idx;
        }
        return step;
    }

}
