package leetCode_31;

/**
 * @author dimdark
 * @date 2017-09-14
 * @time 7:58 PM
 */
public class Solution {

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        int begin, end;
        begin = end = nums.length - 1;
        while (begin > 0 && nums[begin-1] >= nums[begin]) --begin;
        int firstIdx = begin, lastIdx = end;
        if (begin != 0) {
            int targetIdx = begin - 1;
            while(end >= begin && nums[end] <= nums[targetIdx]) --end;
            if (end >= begin) {
                swap(nums, targetIdx, end);
            }
        }
        while (firstIdx < lastIdx) {
            swap(nums, firstIdx, lastIdx);
            ++firstIdx; --lastIdx;
        }
    }

}
