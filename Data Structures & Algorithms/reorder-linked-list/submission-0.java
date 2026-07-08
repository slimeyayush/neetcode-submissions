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
    public void reorderList(ListNode head) {
       if (head == null || head.next == null)
            return;

        ListNode mid = findMiddle(head);

        ListNode secondHead = mid.next;
        mid.next = null;

        secondHead = reverse(secondHead);

         ListNode first = head;
        ListNode second = secondHead;

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        return slow;
    }
}
