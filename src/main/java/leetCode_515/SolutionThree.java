package leetCode_515;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-09-12
 * @time 8:03 AM
 */
public class SolutionThree {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        findMaxValuePerRow(root, 0, rst);
        return rst;
    }

    private void findMaxValuePerRow(TreeNode root, int row, List<Integer> maxs) {
        if (root == null) return;
        if (maxs.size() < row + 1) {
            maxs.add(root.val);
        } else {
            // maxs[row] = (maxs[row] < root.val) ? root.val : maxs[row];
            maxs.set(row, Integer.max(maxs.get(row), root.val));
        }
        findMaxValuePerRow(root.left, row+1, maxs);
        findMaxValuePerRow(root.right, row+1, maxs);
    }

}
