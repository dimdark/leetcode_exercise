package leetCode_98;

import java.util.Stack;

/**
 * @author dimdark
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode preNode = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (preNode != null && preNode.val >= node.val) {
                    return false;
                }
                preNode = node;
                node = node.right;
            }
        }
        return true;
    }

}
