package leetCode_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimdark
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return results;
        }
//        Arrays.sort(candidates);
        backtrack(results, new ArrayList<Integer>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> list, int[] candidates, int remain, int start) {
        if (remain <= 0) {
            if (remain == 0) {
                results.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for(int i = start; i < candidates.length; ++i) {
            list.add(candidates[i]);
            backtrack(results, list, candidates, remain - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

}
