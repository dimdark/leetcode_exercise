package leetCode_24;

/**
 * @author dimdark
 * @date 2017-10-08
 * @time 9:02 PM
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = dummyHead;
        ListNode pNode, qNode, rNode;
        while (node.next != null && node.next.next != null) {
            pNode = node.next;
            qNode = pNode.next;
            rNode = qNode.next;
            node.next = qNode;
            qNode.next = pNode;
            pNode.next = rNode;
            node = pNode;
        }
        return dummyHead.next;
    }

}
