package leetCode_515;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dimdark
 * @date 2017-09-11
 * @time 11:48 PM
 */
public class SolutionTwo {

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
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        int curRowCount = 1, postRowCount;
        while (curRowCount != 0) {
            Integer maxValuePerRow = Integer.MIN_VALUE;
            postRowCount = 0;
            while (curRowCount-- != 0) {
                node = queue.peek();
                queue.poll();
                maxValuePerRow = (maxValuePerRow < node.val) ? node.val : maxValuePerRow;
                if (node.left != null) {
                    postRowCount++;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    postRowCount++;
                    queue.offer(node.right);
                }
            }
            rst.add(maxValuePerRow);
            // update
            curRowCount = postRowCount;
        }
        return rst;
    }

}
