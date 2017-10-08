package leetCode_25;

/**
 * @author dimdark
 * @date 2017-10-08
 * @time 9:58 PM
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    private ListNode reverse(ListNode first, ListNode last) {
        ListNode prev = last;
        while (first != last) {
            ListNode temp = first.next;
            first.next = prev;
            prev = first;
            first = temp;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) return head;
        ListNode node = head;
        for (int i = 0; i < k; ++i) {
            if (node == null) {
                return head;
            }
            node = node.next;
        }
        ListNode newHead = reverse(head, node);
        head.next = reverseKGroup(node, k);
        return newHead;
    }

}
