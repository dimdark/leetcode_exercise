package leetCode_538;

/**
 * @author dimdark
 * @date 2017-09-19
 * @time 8:41 PM
 */
public class SolutionThree {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) { // morris traverse
        TreeNode currNode = root;
        int preSum = 0;
        while (currNode != null) {
            if (currNode.right == null) {
                currNode.val += preSum;
                preSum = currNode.val;
                currNode = currNode.left;
            } else {
                TreeNode predecessor = currNode.right;
                while (predecessor.left != currNode && predecessor.left != null) {
                    predecessor = predecessor.left;
                }
                if (predecessor.left == null) { // set link
                    predecessor.left = currNode;
                    currNode = currNode.right;
                } else { // delete link
                    predecessor.left = null;
                    currNode.val += preSum;
                    preSum = currNode.val;
                    currNode = currNode.left;
                }
            }
        }
        return root;
    }

}
