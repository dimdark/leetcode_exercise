package leetCode_513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimdark
 * @date 2017-09-01
 * @time 10:05 AM
 */
public class SolutionTwo {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> tmpQueue;
        int curCnt = 1, postCnt = 0;
        queue.add(root);
        while(true) {
            tmpQueue = new LinkedList<TreeNode>();
            while(curCnt-- != 0) {
                TreeNode t = queue.peek();
                queue.remove();
                tmpQueue.add(t);
                if(t.left != null) {
                    queue.add(t.left); postCnt++;
                }
                if(t.right != null) {
                    queue.add(t.right); postCnt++;
                }
            }
            if(postCnt == 0) break;
            curCnt = postCnt; postCnt = 0;
        }
        return tmpQueue.peek().val;
    }

}
