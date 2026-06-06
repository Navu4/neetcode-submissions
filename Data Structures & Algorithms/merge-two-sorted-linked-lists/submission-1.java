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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode dummyHead = new ListNode(-1), c1 = null, c2 = null;
        ListNode curr = dummyHead;
        c1 = l1;
        c2 = l2;
        // System.out.println("curr" + curr.val);
        while(curr != null) {
            if(c1 != null && c2 != null) {
                // System.out.println("c1" + c1.val + ", c2" + c2.val);

                if(c1.val < c2.val) {
                    curr.next = c1;
                    c1 = c1.next;
                } else {
                    curr.next = c2;
                    c2 = c2.next;
                }
            } else if(c1 == null) {
                curr.next = c2;
                break;
            } else if(c2 == null) {
                curr.next = c1;
                break;
            }
            curr = curr.next;
        }

        ListNode ans = dummyHead.next; 
        dummyHead.next = null;
        return ans;
    }
}