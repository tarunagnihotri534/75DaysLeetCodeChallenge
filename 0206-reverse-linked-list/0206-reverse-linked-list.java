class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next_node = curr.next; // store next
            curr.next = prev;              // reverse link
            prev = curr;                  // move prev
            curr = next_node;             // move curr
        }

        return prev;
    }
}