package leetCode_349;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimdark
 * @date 2017-09-08
 * @time 10:21 AM
 */
public class SolutionTwo {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> intersectSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; ++i) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; ++i) {
            if (set1.contains(nums2[i]) && !intersectSet.contains(nums2[i])) {
                intersectSet.add(nums2[i]);
            }
        }
        int[] rst = new int[intersectSet.size()];
        int j = 0;
        for (Integer element : intersectSet) {
            rst[j++] = element;
        }
        return rst;
    }

}
