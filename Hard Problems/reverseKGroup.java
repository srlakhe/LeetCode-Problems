/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode itr = head, prev = null;
        int i = 0;
        int count = 0;
        while(count < k && itr != null) {
            count++;
            itr = itr.next;
        }
        if(count < k)
            return head;
        itr = head;
        while(i < k && itr != null) {
            ListNode temp = itr.next;
            itr.next = prev;
            prev = itr;
            itr = temp;
            i++;
        }
        head.next = reverseKGroup(itr, k);
        return prev;
    }
}
