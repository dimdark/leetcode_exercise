package leetCode_35;

/**
 * @author dimdark
 */
public class Solution {

    public int searchInsert(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (numbers[mid] >= target) {
                high = mid;
                if (low == high) {
                    break;
                }
            } else {
                low = mid + 1;
            }
        }
        return (low == high) ? low : numbers.length;
    }

}
