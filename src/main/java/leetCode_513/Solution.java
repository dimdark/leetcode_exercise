package leetCode_513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimdark
 * @date 2017-09-01
 * @time 9:36 AM
 */
public class Solution {

    private int bitreeDepth(TreeNode root) {
        if(root == null) return 0;
        else return Integer.max(bitreeDepth(root.left), bitreeDepth(root.right)) + 1;
    }

    public int findBottomLeftValue(TreeNode root) {
        int level = bitreeDepth(root);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int levelCnt = 1, curCnt = 0;
        q.add(root);
        while(true) {
            if(level-- == 1) break;
            while(levelCnt-- != 0) {
                TreeNode t = q.peek();
                q.remove();
                if(t.left != null) {
                    q.add(t.left); curCnt++;
                }
                if(t.right != null) {
                    q.add(t.right); curCnt++;
                }
            }
            levelCnt = curCnt; curCnt = 0;
        }
        return q.peek().val;
    }

}
