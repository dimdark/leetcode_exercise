package leetCode_228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-09-07
 * @time 8:45 AM
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<String>();
        if (nums == null || nums.length == 0) return rst;
        int up = 0, down = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i-1] + 1) {
                if (up != down) rst.add((new StringBuilder()).append(nums[down]).append("->").append(nums[up]).toString());
                else rst.add(String.valueOf(nums[down]));
                up = down = i;
            } else {
                up++;
            }
        }
        if (up != down) rst.add((new StringBuilder()).append(nums[down]).append("->").append(nums[up]).toString());
        else rst.add(String.valueOf(nums[down]));
        return rst;
    }

}
