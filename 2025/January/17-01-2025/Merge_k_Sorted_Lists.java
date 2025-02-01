import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        // Min-Heap to store nodes by value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Create a dummy node to build the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process the heap
        while (!minHeap.isEmpty()) {
            // Extract the smallest node
            ListNode smallest = minHeap.poll();
            current.next = smallest; // Add it to the merged list
            current = current.next;

            // If the extracted node has a next node, push it into the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        // Return the merged list
        return dummy.next;
    }
}