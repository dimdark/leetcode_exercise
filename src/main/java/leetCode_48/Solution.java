package leetCode_48;

/**
 * @author dimdark
 */
public class Solution {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int begin = 0;
        int end = matrix.length - 1;
        while (begin < end) {
            int[] tempArray = matrix[begin];
            matrix[begin] = matrix[end];
            matrix[end] = tempArray;
            ++begin;
            --end;
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int tempValue = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempValue;
            }
        }
    }

    public void antirotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int tempValue;
        for (int[] row : matrix) {
            int begin = 0;
            int end = row.length - 1;
            while (begin < end) {
                tempValue = row[begin];
                row[begin] = row[end];
                row[end] = tempValue;
                ++begin;
                --end;
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < i; ++j) {
                tempValue = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempValue;
            }
        }
    }

}
