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
    public void reorderList(ListNode head) {
        // find the middle using the slow & fast pointer
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is the mid but we want to start from the next
        // Separating the lists
        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode curr = secondHalf;
        ListNode prev = null;

        // reversing the list
        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // we have two separate lists now
        ListNode firstHalf = head;
        secondHalf = prev;

        while(secondHalf != null) {
            // storing the next refernces
            ListNode nextFirst = firstHalf.next;
            ListNode nextSecond = secondHalf.next;

            // linking
            firstHalf.next = secondHalf;
            secondHalf.next = nextFirst;

            // updating the links
            firstHalf = nextFirst;
            secondHalf = nextSecond;
        }
    }
}
