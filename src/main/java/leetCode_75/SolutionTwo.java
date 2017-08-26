package leetCode_75;

/**
 * @author dimdark
 * @date 2017-08-26
 * @time 10:39 AM
 */
public class SolutionTwo {

    public void sortColors(int[] nums) {
        int p, q, crt;
        p = 0; crt = 0; q = nums.length-1;
        while(crt <= q) { // only one pass
            if(nums[crt] == 0) {
                nums[crt] = nums[p];
                nums[p] = 0;
                p++;
            }
            if(nums[crt] == 2) {
                nums[crt] = nums[q];
                nums[q] = 2;
                q--;
                crt--;
            }
            crt++;
        }
    }

}
