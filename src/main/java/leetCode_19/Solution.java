package leetCode_19;

/**
 * @author dimdark
 * @date 2017-10-07
 * @time 2:59 PM
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fNode = newHead;
        for (int i = 0; i < n; ++i) {
            if (fNode == null) return head;
            fNode = fNode.next;
        }
        if (fNode == null) return head;
        ListNode sNode = newHead;
        while (fNode.next != null) {
            sNode = sNode.next;
            fNode = fNode.next;
        }
        sNode.next = sNode.next.next;
        return newHead.next;
    }

}
