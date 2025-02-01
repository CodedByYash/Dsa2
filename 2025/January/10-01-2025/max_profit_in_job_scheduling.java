import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Combine jobs into a single array and sort by end time
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        // DP array to store maximum profit up to each job
        int[] dp = new int[n];
        dp[0] = jobs[0][2]; // Base case: profit of the first job

        for (int i = 1; i < n; i++) {
            // Profit if we include the current job
            int includeProfit = jobs[i][2];

            // Find the last non-overlapping job using binary search
            int lastNonOverlap = binarySearch(jobs, i);
            if (lastNonOverlap != -1) {
                includeProfit += dp[lastNonOverlap];
            }

            // Take the maximum of including or excluding the current job
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    private int binarySearch(int[][] jobs, int currentIndex) {
        int low = 0, high = currentIndex - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][1] <= jobs[currentIndex][0]) {
                if (jobs[mid + 1][1] <= jobs[currentIndex][0]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
