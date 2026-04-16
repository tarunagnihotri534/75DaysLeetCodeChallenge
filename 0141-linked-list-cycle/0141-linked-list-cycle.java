public class Solution {
    public boolean hasCycle(ListNode head) {
        // Edge case: empty list or single node cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Moves 1 step
            fast = fast.next.next;     // Moves 2 steps

            // If they meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end, no cycle exists
        return false;
    }
}