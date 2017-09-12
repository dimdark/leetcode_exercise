package leetCode_515;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dimdark
 * @date 2017-09-11
 * @time 11:38 PM
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rst = new LinkedList<Integer>();
        if (root == null) return rst;
        Queue<TreeNode> currQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> postQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> tempQueue;
        TreeNode node = root;
        currQueue.offer(node);
        while (!currQueue.isEmpty()) {
            Integer maxValuePerRow = Integer.MIN_VALUE;
            while (!currQueue.isEmpty()) {
                node = currQueue.peek();
                currQueue.poll();
                maxValuePerRow = (node.val > maxValuePerRow) ? node.val : maxValuePerRow;
                if (node.left != null) postQueue.offer(node.left);
                if (node.right != null) postQueue.offer(node.right);
            }
            rst.add(maxValuePerRow);
            // update
            tempQueue = currQueue;
            currQueue = postQueue;
            postQueue = tempQueue;
        }
        return rst;
    }


}
