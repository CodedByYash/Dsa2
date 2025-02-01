public class Reverse_Nodes_in_k_Group {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        // Base case: If k is 1 or the list is empty, return the head
        if (head == null || k == 1)
            return head;

        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Count the total number of nodes in the list
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Start from the dummy node
        ListNode prevGroupEnd = dummy;

        // Iterate over the list in groups of k
        while (count >= k) {
            // Reverse the next k nodes
            ListNode start = prevGroupEnd.next;
            ListNode end = start;
            for (int i = 1; i < k; i++) {
                end = end.next;
            }
            ListNode nextGroupStart = end.next;

            // Reverse the current group
            ListNode prev = nextGroupStart;
            ListNode curr = start;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the reversed group with the previous group
            prevGroupEnd.next = end;
            prevGroupEnd = start;

            // Update count
            count -= k;
        }

        // Return the new head of the list
        return dummy.next;
    }
}