/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode itr1 = headA, itr2 = headB;
        while(itr1 != itr2) {
            itr1 = itr1 != null ? itr1.next : headB;
            itr2 = itr2 != null ? itr2.next : headA;
        }
        return itr1;
    }
}
