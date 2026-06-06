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
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode forw = curr.next;

            curr.next = prev;
            prev = curr;

            curr = forw;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = l1;
        ListNode rl2 = l2;

        ListNode head = new ListNode(-1);
        ListNode curr = head; 

        int carry = 0;
        while(rl1 != null && rl2 != null) {

            int sum = rl1.val + rl2.val + carry;
            carry = sum >= 10 ? 1 : 0;
            int val = sum % 10;
            
            // System.out.println("rl1:" + rl1.val + " & " + rl2.val + " sum:" + sum + " carry:" + carry + " val:" + val);

            ListNode node = new ListNode(val);
            curr.next = node;
            curr = node;

            rl1 = rl1.next;
            rl2 = rl2.next;
        }
        System.out.println("");

        // // carry
        if(rl1 != null || rl2 != null) {

            rl1 = rl1 != null ? rl1 : rl2;

            while(rl1 != null) {
                int sum = rl1.val + carry;
                carry = sum >= 10 ? 1 : 0;
                int val = sum % 10;
                // System.out.println("rl1:" + rl1.val + " sum:" + sum + " carry:" + carry + " val:" + val);

                ListNode node = new ListNode(val);
                curr.next = node; 
                curr = curr.next;

                rl1 = rl1.next;
            }
        }

        if(carry == 1) {
            curr.next = new ListNode(1);
        }

        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}
