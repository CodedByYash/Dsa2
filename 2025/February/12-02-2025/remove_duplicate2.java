public class remove_duplicate2 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0, head); // Dummy node before head
        ListNode prev = dummy; // Pointer to track the last unique node
        ListNode current = head;

        while (current != null) {
            // If current node is a duplicate
            if (current.next != null && current.val == current.next.val) {
                // Skip all nodes with the same value
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                prev.next = current.next; // Remove duplicates
            } else {
                prev = prev.next; // Move prev only if no duplicates were found
            }
            current = current.next; // Move to next node
        }

        return dummy.next; // Return new head
    }
}