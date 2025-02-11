// Remove Duplicates from Sorted Array II
public class remove_duplicate {
    public int removeDuplicates(int[] nums) {
        int j = 0; // Position to place valid elements
        for (int num : nums) {
            // If j < 2, we can place any element.
            // If j >= 2, check if current num is different from nums[j-2]
            if (j < 2 || num != nums[j - 2]) {
                nums[j] = num;
                j++;
            }
        }
        return j;
    }
}