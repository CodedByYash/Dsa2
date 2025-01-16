public class Remove_Nth_Node_From_End_of_List {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node
        slow.next = slow.next.next;

        // Return the new head
        return dummy.next;
    }
}