package leetCode_34;

/**
 * @author dimdark
 */
public class Solution {

    public int findFirstIndexOfEqualElement(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (numbers[mid] == target) {
                high = mid;
                if (low == high) {
                    break;
                }
            } else if (numbers[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low == high) ? low : -1;
    }

    public int findLastIndexOfEqualElement(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (numbers[mid] == target) {
                low = mid;
                if (low == high) {
                    break;
                }
                if (low + 1 == high) {
                    if (numbers[low] == numbers[high]) {
                        low = high;
                    } else {
                        high = low;
                    }
                    break;
                }
            } else if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (low == high) ? low : -1;
    }

    public int[] searchRange(int[] numbers, int target) {
        int[] results = new int[2];
        results[0] = results[1] = -1;
        if (numbers == null || numbers.length == 0) {
            return results;
        }
        results[0] = findFirstIndexOfEqualElement(numbers, target);
        results[1] = findLastIndexOfEqualElement(numbers, target);
        return results;
    }

}
