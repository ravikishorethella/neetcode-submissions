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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode groupPrev = dummy;
        while(true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            if(kthNode == null) {
                break;
            }

            ListNode groupNext = kthNode.next;
            ListNode groupStart = groupPrev.next;

            ListNode prev = groupNext;
            ListNode curr = groupStart;

            for(int i = 0; i < k; i++) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            groupPrev.next = prev;
            groupPrev = groupStart;
        }
        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
