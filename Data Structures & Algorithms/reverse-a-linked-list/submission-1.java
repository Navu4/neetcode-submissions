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
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head; 
             
        ListNode prev = null, curr = head;

        while(curr != null) {
            ListNode forw = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forw;
        } 

        return prev;
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
}
