package leetCode_90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-09-20
 * @time 8:57 AM
 */
public class Solution {

    private LinkedList<List<Integer>> rst = new LinkedList<List<Integer>>();

    private void helper(int[] nums, int currIdx, LinkedList<Integer> list, boolean taken) {
        if (currIdx >= nums.length) {
            // rst.add(list);
            rst.add(new LinkedList<Integer>(list));
        } else {
            helper(nums, currIdx + 1, list, false); // not get
            if (taken || nums[currIdx] != nums[currIdx - 1]) { // get
                list.add(nums[currIdx]);
                helper(nums, currIdx + 1, list, true); // get
                list.removeLast();
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return rst;
        Arrays.sort(nums);
        helper(nums, 0, new LinkedList<Integer>(), true); // true for the first element
        return rst;
    }

}
