package leetCode_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimdark
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return results;
        }
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(results, new ArrayList<Integer>(), candidates, used, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> list,
                           int[] candidates, boolean[] used, int remain, int start) {
        if (remain <= 0) {
            if (remain == 0) {
                results.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (used[i] || i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(candidates[i]);
            backtrack(results, list, candidates, used, remain - candidates[i], i + 1);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
