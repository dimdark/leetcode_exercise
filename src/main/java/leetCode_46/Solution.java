package leetCode_46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimdark
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        boolean[] used = new boolean[nums.length];
        backtrack(results, new ArrayList<Integer>(), nums, used);
        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtrack(results, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
