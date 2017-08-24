package leetCode_275;

/**
 * @author dimdark
 * @date 2017-08-24
 * @time 11:03 AM
 */
public class SolutionTwo {

    public int hIndex(int[] citations) {
        int left, right, mid, len;
        len = citations.length;
        left = 0; right = len - 1;
        while(left <= right) {
            mid = (left+right) >> 1;
            if(citations[mid] == len - mid) return len - mid;
            else if(citations[mid] > len - mid) right = mid - 1;
            else left = mid + 1;
        }
        return len - (right+1);
    }

}
