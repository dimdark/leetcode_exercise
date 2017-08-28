package leetCode_378;

/**
 * @author dimdark
 * @date 2017-08-28
 * @time 7:25 PM
 */
public class MainTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(solution.kthSmallest(matrix,8));
    }

}
