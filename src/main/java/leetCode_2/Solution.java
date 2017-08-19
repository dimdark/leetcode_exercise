package leetCode_2;

/**
 * 优雅的解法<br/>
 * @author dimdark
 * @date 2017-04-18
 * @time 8:07 PM
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode sentinel = new ListNode(0);
        ListNode preResult = sentinel;
        int sum = 0;
        while (l1!=null || l2!=null){
            sum /= 10;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            sentinel.next = new ListNode(sum%10);
            sentinel = sentinel.next;
        }
        if(sum/10 == 1){
            sentinel.next = new ListNode(sum/10);
        }
        return preResult.next;
    }

}
