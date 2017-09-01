package leetCode_513;

/**
 * @author dimdark
 * @date 2017-09-01
 * @time 10:37 AM
 */
public class SolutionThree {

    private int ans = 0;
    private int h = 0;
    private void findBottomLeftValue(TreeNode root, int depth) {
        if(h < depth) {
            ans = root.val; h = depth;
        }
        if(root.left != null) findBottomLeftValue(root.left, depth + 1);
        if(root.right != null) findBottomLeftValue(root.right, depth + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }

}
