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


    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public ListNode middle(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode mid = middle(head);
        ListNode secondPart = mid.next, firstPart = head;
        
        mid.next = null;
        
        secondPart = reverse(secondPart);
        ListNode c1 = firstPart, c2 = secondPart;
        
        while(c1 != null && c2 != null){
            ListNode c1Next = c1.next;
            ListNode c2Next = c2.next; 
            
            c1.next = c2;
            c2.next = c1Next;
            
            c1 = c1Next;
            c2 = c2Next;
        }

    }
}
