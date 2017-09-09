package leetCode_142;

/**
 * @author dimdark
 * @date 2017-09-09
 * @time 10:59 AM
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head, entry = head;
        while (fast.next != null && fast.next.next != null) { // non-cycle if not true
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { // encounter
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null; // non-cycle
    }

}
