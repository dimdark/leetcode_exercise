package leetCode_23;

/**
 * @author dimdark
 * @date 2017-10-08
 * @time 8:20 PM
 */
public class SolutionTwo {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode falseHead = new ListNode(-1);
        ListNode currNode = falseHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currNode.next = list1;
                currNode = list1;
                list1 = list1.next;
            } else {
                currNode.next = list2;
                currNode = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            currNode.next = list1;
        } else if (list2 != null) {
            currNode.next = list2;
        }
        return falseHead.next;
    }

    private ListNode mergeLists(ListNode[] lists, int begin, int end) { // [begin, end]
        if (begin < 0 || end < 0 || begin > end) { // bad conditions
            throw new IllegalArgumentException("impossible arguments!");
        }
        if (begin == end) {
            return lists[begin];
        }
        if (begin + 1 == end) {
            return merge(lists[begin], lists[end]);
        }
        int mid = begin + ((end - begin) >> 1);
        ListNode leftList = mergeLists(lists, begin, mid);
        ListNode rightList = mergeLists(lists, mid + 1, end);
        return merge(leftList, rightList);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

}
