package leetCode_128;

import java.util.HashMap;

/**
 * @author dimdark
 * @date 2017-09-16
 * @time 10:35 PM
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums == null) return 0;
        int maxLen = 0, len, left, right;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) { // not contain
//                left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                left = map.getOrDefault(num - 1, 0);
//                right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                right = map.getOrDefault(num + 1, 0);
                len = left + right + 1;
                maxLen = (maxLen < len) ? len : maxLen; // update maximum
                map.put(num, len);
                // core thought: put the current max length to left boundary and right boundary
                map.put(num - left, len);
                map.put(num + right, len);
            }
        }
        return maxLen;
    }

}
