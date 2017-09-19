package leetCode_538;

/**
 * @author dimdark
 * @date 2017-09-19
 * @time 7:10 PM
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    private int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }

}
