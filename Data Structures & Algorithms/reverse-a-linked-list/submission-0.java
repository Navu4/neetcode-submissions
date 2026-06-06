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
        if(head == null)
            return null;

        ListNode prev = null, curr = head, next = head.next; 
        while(curr != null) {
            // 1: update curr next val 
            curr.next = prev;
            
            // 2: update prev pointer for next node 
            prev = curr;
            curr = next;

            // 3: update next to curr.next; 
            if(curr != null)
                next = curr.next;
        }
        return prev;
    }
}
