package leetCode_4;

/**
 * @author dimdark
 * @date 2017-10-04
 * @time 5:17 PM
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            int[] tempArray = nums1;
            nums1 = nums2;
            nums2 = tempArray;
            int tempValue = len1;
            len1 = len2;
            len2 = tempValue;
        }
        // len1 <= len2
        int leftIdx = 0, rightIdx = len1;
        int halfLen = len1 + ((len2 + 1 - len1) >> 1);
        while (leftIdx <= rightIdx) {
            int i = leftIdx + ((rightIdx - leftIdx) >> 1);
            int j = halfLen - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) { // i > 0 ---> j < len2
                rightIdx = i - 1;
            } else if (i < len1 && nums2[j - 1] > nums1[i]) { // i < len1 ---> j > 0
                leftIdx = i + 1;
            } else {
                int maxValueOfLeftPart = (i == 0) ? nums2[j - 1] :
                        (j == 0) ? nums1[i - 1] :
                                Integer.max(nums1[i - 1], nums2[j - 1]);
                if (((len1 + len2) & 1) == 1) { // len1 + len2 is odd
                    return (double)maxValueOfLeftPart;
                }
                int minValueOfRightPart = (i == len1) ? nums2[j] :
                        (j == len2) ? nums1[i] :
                                Integer.min(nums1[i], nums2[j]);
                return (maxValueOfLeftPart + minValueOfRightPart) / 2.0;
            }
        }
        return 0.0;
    }

}
