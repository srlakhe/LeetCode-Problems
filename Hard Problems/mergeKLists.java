/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a, b) -> a.val-b.val);
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null)
                minheap.offer(lists[i]);
        ListNode head = null, itr = null;
        while(!minheap.isEmpty()) {
            ListNode temp = minheap.poll();
            if(head == null) {
                head = temp;
                itr = temp;
            } else {
                itr.next = temp;
                itr = itr.next;
            }
            if(temp.next != null) {
                minheap.offer(temp.next);
            }
        }
        return head;
    }
}
