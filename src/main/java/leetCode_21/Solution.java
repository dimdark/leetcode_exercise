package leetCode_21;

/**
 * @author dimdark
 * @date 2017-10-07
 * @time 4:01 PM
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode falseHead = new ListNode(-1);
        ListNode firstNode = l1, secondNode = l2;
        ListNode currentNode = falseHead;
        while (firstNode != null && secondNode != null) {
            if (firstNode.val < secondNode.val) {
                currentNode.next = firstNode;
                currentNode = firstNode;
                firstNode = firstNode.next;
            } else {
                currentNode.next = secondNode;
                currentNode = secondNode;
                secondNode = secondNode.next;
            }
        }
        if (firstNode != null) {
            currentNode.next = firstNode;
        } else if (secondNode != null) {
            currentNode.next = secondNode;
        }
        return falseHead.next;
    }

}
