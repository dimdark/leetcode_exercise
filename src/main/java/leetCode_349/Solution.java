package leetCode_349;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dimdark
 * @date 2017-09-08
 * @time 10:19 AM
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length) {
            if (j >= nums2.length) break;
            if (nums1[i] == nums2[j]) {
                if (i == 0 || (i > 0 && nums1[i] != nums1[i-1])) {
                    list.add(nums1[i]);
                }
                ++i; ++j;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                ++i;
            }
        }
        int[] rst = new int[list.size()];
        for (int k = 0; k < list.size(); ++k) {
            rst[k] = list.get(k);
        }
        return rst;
    }

}
