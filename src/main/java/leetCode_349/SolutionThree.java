package leetCode_349;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dimdark
 * @date 2017-09-08
 * @time 10:38 AM
 */
public class SolutionThree {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(set::contains).toArray();
    }

}
