package leetCode_203;

/**
 * @author dimdark
 * @date 2017-09-11
 * @time 8:14 AM
 */
public class SolutionTwo {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(-1); // create ideal head node
        fakeHead.next = head;
        ListNode currNode = head, preNode = fakeHead;
        while (currNode != null) {
            if (currNode.val == val) {
                preNode.next = currNode.next;
            } else {
                preNode = currNode;
            }
            currNode = currNode.next;
        }
        return fakeHead.next;
    }

}
