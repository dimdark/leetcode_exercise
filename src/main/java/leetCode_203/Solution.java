package leetCode_203;

/**
 * @author dimdark
 * @date 2017-09-11
 * @time 8:09 AM
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode preNode, currNode;
        while (head != null && head.val == val) head = head.next; // first no-delete node
        preNode = currNode = head;
        while (currNode != null) {
            if (currNode.val == val) {
                preNode.next = currNode.next;
            } else {
                preNode = currNode;
            }
            currNode = currNode.next;
        }
        return head;
    }

}
