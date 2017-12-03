package theme.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimdark
 */
public class UniqueSubSetCreator {

    public List<List<Integer>> create(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        backtrack(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> list, int[] nums, int start) {
        results.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(results, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
