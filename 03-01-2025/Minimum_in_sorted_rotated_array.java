public class Minimum_in_sorted_rotated_array {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // If mid element is less than end, the minimum is in the left part (including
            // mid)
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                // Otherwise, the minimum is in the right part (excluding mid)
                start = mid + 1;
            }
        }

        // Start will point to the minimum element
        return nums[start];
    }
}
