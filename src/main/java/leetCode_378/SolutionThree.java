package leetCode_378;

/**
 * @author dimdark
 * @date 2017-08-28
 * @time 9:51 PM
 */
public class SolutionThree {

    public int kthSmallest(int[][] matrix, int k) { // binary search based range
        int leftVal = matrix[0][0], rightVal = matrix[matrix.length-1][matrix[0].length-1]+1, midVal;
        while(leftVal < rightVal) {// [leftVal, rightVal)
            // midVal = (leftVal+rightVal)>>1; sum of variable leftVal and rightVal may cause overflow
            midVal = leftVal + ((rightVal-leftVal)>>1); // >> priority less than + priority
            int cnt = 0, j = matrix[0].length-1;
            for(int i = 0; i < matrix.length; ++i) {
                while(j>=0 && matrix[i][j]>midVal) --j;
                cnt += (j+1);
            }
            if(cnt < k) leftVal = midVal + 1;
            else rightVal = midVal;
        }
        return leftVal;
    }

}
