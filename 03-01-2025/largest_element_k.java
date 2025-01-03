import java.util.Random;

public class largest_element_k {
    public int findKthLargest(int[] nums, int k) {
        // Convert kth largest to index (0-based) for quickselect
        int targetIndex = nums.length - k;
        return quickselect(nums, 0, nums.length - 1, targetIndex);
    }

    private int quickselect(int[] nums, int left, int right, int targetIndex) {
        // Choose a random pivot index
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);

        // Partition the array and get the pivot's final position
        int finalPivotIndex = partition(nums, left, right, pivotIndex);

        // If the pivot is at the target index, return it
        if (finalPivotIndex == targetIndex) {
            return nums[finalPivotIndex];
        } else if (finalPivotIndex < targetIndex) {
            // Search the right part of the array
            return quickselect(nums, finalPivotIndex + 1, right, targetIndex);
        } else {
            // Search the left part of the array
            return quickselect(nums, left, finalPivotIndex - 1, targetIndex);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        // Move pivot to the end
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        // Move all elements smaller than pivotValue to the left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }
        // Move pivot to its final position
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
