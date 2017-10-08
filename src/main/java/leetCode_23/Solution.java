package leetCode_23;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author dimdark
 * @date 2017-10-08
 * @time 7:14 PM
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, Comparator.comparingInt(node -> node.val));
        ListNode falseHead = new ListNode(-1);
        ListNode currentNode = falseHead;
        // initial
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                q.offer(lists[i]);
            }
        }
        while (true) { // q is not empty
            ListNode minNode = q.peek();
            q.poll();
            currentNode.next = minNode;
            currentNode = minNode;
            if (q.size() == 0) break;
            if (minNode.next != null) {
                q.offer(minNode.next);
            }
        }
        return falseHead.next;
    }

}
