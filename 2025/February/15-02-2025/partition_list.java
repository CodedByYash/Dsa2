public class partition_list {
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

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0); // Dummy head for left partition
        ListNode rightHead = new ListNode(0); // Dummy head for right partition
        ListNode left = leftHead, right = rightHead;

        while (head != null) {
            if (head.val < x) {
                left.next = head; // Append to left partition
                left = left.next;
            } else {
                right.next = head; // Append to right partition
                right = right.next;
            }
            head = head.next; // Move to next node
        }

        right.next = null; // End right partition
        left.next = rightHead.next; // Connect left and right partitions

        return leftHead.next; // Skip dummy node
    }
}