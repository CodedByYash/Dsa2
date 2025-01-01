import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to hold merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 3: Iterate through intervals
        for (int[] interval : intervals) {
            // If merged is empty or no overlap with the last interval in merged
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Merge intervals by updating the end time of the last interval
                merged.get(merged.size() - 1)[1] = 
                    Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Step 4: Convert merged list to a 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }

    // Driver method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);

        // Print the merged intervals
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
