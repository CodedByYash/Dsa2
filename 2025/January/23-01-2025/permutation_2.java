import java.util.*;

class permutation_2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        boolean[] used = new boolean[nums.length]; // Keep track of used elements
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add current permutation to the result
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used or if it’s a duplicate and the previous identical element wasn’t used
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            
            tempList.add(nums[i]); // Add the current element
            used[i] = true; // Mark it as used
            
            backtrack(nums, tempList, used, result); // Recurse
            
            // Backtrack
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }
}
