package leetCode_16;

import java.util.Arrays;

/**
 * @author dimdark
 * @date 2017-08-27
 * @time 9:49 AM
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int i, j, k, temp;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(i = 0; i < nums.length-2; ++i) { // reduce unpossible cases
            j = i+1; k = nums.length-1;
            while(j < k) {
                temp = nums[i] + nums[j] + nums[k];
                ans = Math.abs(target-ans)>Math.abs(target-temp) ? temp : ans;
                if(temp < target) j++;
                else if(temp > target) k--;
                else return ans;
            }
        }
        return ans;
    }

}
