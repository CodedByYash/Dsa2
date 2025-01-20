import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_sum_2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to handle duplicates and facilitate early termination
        Arrays.sort(candidates);
        // Start backtracking
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        // Base case: if the target becomes zero, add the combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Iterate through the candidates
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // If the current number is greater than the remaining target, stop further processing
            if (candidates[i] > target) {
                break;
            }

            // Include the current number in the combination
            combination.add(candidates[i]);
            // Recur with the remaining target and move to the next index
            backtrack(candidates, target - candidates[i], i + 1, combination, result);
            // Backtrack by removing the last added number
            combination.remove(combination.size() - 1);
        }
    }
}