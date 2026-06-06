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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode c1 = list1, c2 = list2;
        
        if(c1 == null || c2 == null)
            return c1 == null ? c2 : c1;
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(c1 != null && c2 != null && curr != null){
            if(c1.val < c2.val) {
                curr.next = c1;
                c1 = c1.next;
            } else {
                curr.next = c2;
                c2 = c2.next;
            }
            
            curr = curr.next;
        }
        
        if(c1 != null && curr != null)
            curr.next = c1;
        else if(c2 != null && curr != null)
            curr.next = c2;
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si == ei)
            return lists[si];
        
        int mid = (si + ei)/ 2;
        ListNode leftMergeList = mergeKLists(lists, si, mid);
        ListNode rightMergeList = mergeKLists(lists, mid + 1, ei);
        
        return mergeTwoLists(leftMergeList, rightMergeList);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
}