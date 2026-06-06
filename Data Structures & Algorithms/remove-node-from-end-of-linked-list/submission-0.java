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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n == 1)) {
            return null;
        }

        ListNode prev = null, curr = head, ptr = head;
        int count = 1;

        while(count != n) {
            System.out.println("ptr:" + ptr.val);
            ptr = ptr.next;
            count++;
        }

        System.out.println("");
        while(ptr.next != null && curr != null) {
            System.out.println("ptr: " + ptr.val + " " + " curr: " + curr.val);
            ListNode forw = curr.next;
            ListNode ptrF = ptr.next;

            prev = curr;
            curr = forw;

            ptr = ptrF;
        }
        System.out.println("");
        ListNode newHead = head;
        if(prev != null) {
            prev.next = curr.next;
            curr.next = null;
        } else {
            // curr is head 
            newHead = curr.next;
            curr.next = null;
        }

        return newHead;
    }
}
