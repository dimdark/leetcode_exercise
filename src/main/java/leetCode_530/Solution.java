package leetCode_530;

/**
 * @author dimdark
 * @date 2017-09-21
 * @time 10:27 AM
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return -1; //not calculate
        if (root.left == null && root.right == null) return -1; // not calculate
        int preValue = -1, currValue, minAbsValue = Integer.MAX_VALUE;
        TreeNode node = root, predecessor;
        while (node != null) { // mirros traverse
            if (node.left == null) {
                currValue = node.val;
                if (preValue != -1) {
                    minAbsValue = Math.min(minAbsValue, Math.abs(currValue - preValue));
                }
                preValue = currValue;
                node = node.right;
            } else {
                predecessor = node.left;
                while (predecessor.right != node && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right != null) { // delete link
                    predecessor.right = null;
                    currValue = node.val;
                    if (preValue != -1) {
                        minAbsValue = Math.min(minAbsValue, Math.abs(currValue - preValue));
                    }
                    preValue = currValue;
                    node = node.right;
                } else { // set link
                    predecessor.right = node;
                    node = node.left;
                }
            }
        }
        return minAbsValue;
    }

}
