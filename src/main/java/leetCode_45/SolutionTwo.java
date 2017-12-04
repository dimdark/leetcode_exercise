package leetCode_45;

/**
 * @author dimdark
 */
public class SolutionTwo {

    public int jump(int[] nums) {
        int step = 0;
        int targetIdx = 0;
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (i == targetIdx) {
                ++step;
                targetIdx = maxReach;
            }
        }
        System.out.println(targetIdx); // 到达的最远距离
        return step;
    }

    public static void main(String[] args) {
        SolutionTwo solution  = new SolutionTwo();
        int[] array = {1, 0, 2, 0, 3};
        System.out.println(solution.jump(array));
    }

}
