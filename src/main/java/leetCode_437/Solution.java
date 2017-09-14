package leetCode_437;

/**
 * @author dimdark
 * @date 2017-09-14
 * @time 11:12 AM
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    private int pathCountPerNode(TreeNode root, long sum, long preSum) {
        int cnt = 0;
        if (root.val + preSum == sum) cnt++;
        if (root.left != null) cnt += pathCountPerNode(root.left, sum, preSum+root.val);
        if (root.right != null) cnt += pathCountPerNode(root.right, sum, preSum+root.val);
        return cnt;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int pathCnt = pathCountPerNode(root, sum, 0);
        pathCnt += pathSum(root.left, sum);
        pathCnt += pathSum(root.right, sum);
        return pathCnt;
    }

}
