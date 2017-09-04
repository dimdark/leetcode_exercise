package leetCode_110;

/**
 * @author dimdark
 * @date 2017-09-04
 * @time 8:20 AM
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private int balanceDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = balanceDepth(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = balanceDepth(root.right);
        if (rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        else return Integer.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return balanceDepth(root) != -1;
    }

}
