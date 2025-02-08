class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) { // Swap with low pointer
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) { // Already in correct position
                mid++;
            } else { // Swap with high pointer
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
