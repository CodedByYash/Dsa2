public class remove_duplicate_list_2 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
    
            ListNode current = head; // Pointer to traverse the list
    
            while (current != null && current.next != null) {
                if (current.val == current.next.val) {
                    current.next = current.next.next; // Skip duplicate
                } else {
                    current = current.next; // Move forward
                }
            }
    
            return head;
        }
    }