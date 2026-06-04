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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if(head != null) {
                minHeap.add(head);
            }
        }

        while(!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            curr.next = smallestNode;
            curr = curr.next;
            if(smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        return dummy.next;
    }
}
