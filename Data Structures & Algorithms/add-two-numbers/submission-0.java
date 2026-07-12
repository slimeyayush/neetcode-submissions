/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempA = l1;
        ListNode tempB = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(tempA != null || tempB != null || carry > 0) {
            int sum  = (tempA == null)?0:tempA.val;
            sum += (tempB == null)?0:tempB.val;
            sum += carry;
            int nodeVal = (sum)%10;
            carry = (sum)/10;
            ListNode curr = new ListNode(nodeVal);
            if(prev!=null) {
                prev.next = curr;
                prev = curr;
            }
            if(tempA != null) {
                tempA = tempA.next;
            }
            if(tempB != null) {
                tempB = tempB.next;
            }
        }

        return dummy.next;
    }
}
