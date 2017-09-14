package leetCode_31;

/**
 * @author dimdark
 * @date 2017-09-14
 * @time 8:14 PM
 */
public class SolutionTwo {

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
            while (begin < end) {
                if (nums[end] > nums[targetIdx]) break;
                if (begin + 1 == end && nums[begin] > nums[targetIdx]) {
                    end = begin; break;
                }
                int mid = begin + ((end-begin)>>1);
                if (nums[targetIdx] >= nums[mid]) end = mid - 1;
                else begin = mid;
            }
            swap(nums, targetIdx, end);
        }
        while (firstIdx < lastIdx) {
            swap(nums, firstIdx, lastIdx);
            ++firstIdx; --lastIdx;
        }
    }

    public static void main(String[] args) {
        SolutionTwo solutionTwo = new SolutionTwo();
        int[] nums = {2, 2, 7, 5, 4, 3, 2, 2, 1};
        solutionTwo.nextPermutation(nums);
    }

}
