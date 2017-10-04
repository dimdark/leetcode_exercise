package leetCode_18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-10-04
 * @time 8:04 PM
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new LinkedList<List<Integer>>();
        if (nums == null || nums.length < 4) return rst;
        Arrays.sort(nums);
        int i = 0, j;
        while (i < nums.length - 3) {
            j = i + 1;
            while (j < nums.length - 2) {
                int newTarget = target - nums[i] - nums[j];
                int leftIdx = j + 1, rightIdx = nums.length - 1;
                while (leftIdx < rightIdx) {
                    int sum = nums[leftIdx] + nums[rightIdx];
                    if (newTarget < sum) {
                        --rightIdx;
                    } else if (newTarget > sum) {
                        ++leftIdx;
                    } else {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[leftIdx]);
                        list.add(nums[rightIdx]);
                        rst.add(list);
                        ++leftIdx; --rightIdx;
                        while (leftIdx < nums.length && nums[leftIdx - 1] == nums[leftIdx]) {
                            ++leftIdx;
                        }
                        while (rightIdx > j && nums[rightIdx + 1] == nums[rightIdx]) {
                            --rightIdx;
                        }
                    }
                }
                ++j;
                while (j < nums.length - 2 && nums[j - 1] == nums[j]) {
                    ++j;
                }
            }
            ++i;
            while (i < nums.length - 3 && nums[i - 1] == nums[i]) {
                ++i;
            }
        }
        return rst;
    }

}
