import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        // Explore all possible subsets
        for (int i = index; i < nums.length; i++) {
            // Include nums[i] in the current subset
            currentSubset.add(nums[i]);
            // Recurse with the next index
            backtrack(nums, i + 1, currentSubset, result);
            // Backtrack by removing nums[i]
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
