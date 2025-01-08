public class Unique_paths {
    public int uniquePaths(int m, int n) {
        // Create a memoization table initialized with -1
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(0, 0, m, n, memo);
    }

    private int dfs(int r, int c, int m, int n, int[][] memo) {
        // Base case: If we reach the bottom-right corner
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        // If out of bounds, return 0
        if (r >= m || c >= n) {
            return 0;
        }

        // If the result is already computed, return it
        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        // Recursive calls: move right and down
        memo[r][c] = dfs(r, c + 1, m, n, memo) + dfs(r + 1, c, m, n, memo);

        return memo[r][c];
    }
}