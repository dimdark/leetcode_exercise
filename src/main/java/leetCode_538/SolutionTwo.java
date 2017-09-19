package leetCode_538;

import java.util.LinkedList;

/**
 * @author dimdark
 * @date 2017-09-19
 * @time 7:26 PM
 */
public class SolutionTwo {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> stk = new LinkedList<TreeNode>(); // preferable
        TreeNode node = root;
        int preSum = 0;
        while (stk.size() != 0 || node != null) { // !(stk.size == 0 && node == null)
            while (node != null) {
                stk.addFirst(node); // stk.push(node):
                node = node.right;
            }
            node = stk.peekFirst(); // node = stk.peek();
            stk.removeFirst(); // stk.pop();
            node.val += preSum;
            preSum = node.val;
            node = node.left;
        }
        return root;
    }

}
