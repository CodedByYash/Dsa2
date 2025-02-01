class Swap_Nodes_in_Pairs {
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

    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Pointer to track the node before the pair being swapped
        ListNode prev = dummy;

        // Traverse the list
        while (prev.next != null && prev.next.next != null) {
            // Identify the nodes to swap
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap the nodes
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move to the next pair
            prev = first;
        }

        // Return the new head of the list
        return dummy.next;
    }
}
