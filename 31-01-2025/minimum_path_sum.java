class minimum_path_sum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = grid[0][0];

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j-1] + grid[0][j];
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // First column
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
            }
        }

        return dp[n-1]; // Last element is the answer
    }
}
