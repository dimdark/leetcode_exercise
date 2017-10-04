package leetCode_15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-10-04
 * @time 7:15 PM
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new LinkedList<List<Integer>>();
        if (nums == null || nums.length < 3) return rst;
        Arrays.sort(nums);
        int idx = 0;
        while(idx < nums.length - 2) {
            int target = -nums[idx];
            int leftIdx = idx + 1, rightIdx = nums.length - 1;
            while (leftIdx < rightIdx) {
                int sum = nums[leftIdx] + nums[rightIdx];
                if (sum > target) {
                    --rightIdx;
                } else if (sum < target) {
                    ++leftIdx;
                } else {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(nums[idx]);
                    list.add(nums[leftIdx]);
                    list.add(nums[rightIdx]);
                    rst.add(list);
                    ++leftIdx; --rightIdx;
                    while (leftIdx < nums.length && nums[leftIdx - 1] == nums[leftIdx]) {
                        ++leftIdx;
                    }
                    while (rightIdx > -1 && nums[rightIdx + 1] == nums[rightIdx]) {
                        --rightIdx;
                    }
                }
            }
            ++idx;
            while(idx < nums.length - 2 && nums[idx - 1] == nums[idx]) {
                ++idx;
            }
        }
        return rst;
    }

}
