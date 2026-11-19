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
    public ListNode reverseList(ListNode head) {
        // 0->1->2->3 3->2->1->0 
        // we're disconnecting processed nodes and making them prev then curr.next = prev attaches the current node to processed list
        //we're not reversing the list in one go we're building a new one while connecting new nodes ahead of preprocessed one using curr.next = prev; prev is last processed node 2->1->0
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next; // 1
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
