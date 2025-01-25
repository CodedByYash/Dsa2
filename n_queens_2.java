class n_queens_2 {
    public int totalNQueens(int n) {
        // Sets to track the columns and diagonals where queens are placed
        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];
        
        return backtrack(0, n, columns, diagonal1, diagonal2);
    }
    
    private int backtrack(int row, int n, boolean[] columns, boolean[] diagonal1, boolean[] diagonal2) {
        // Base case: All queens are placed
        if (row == n) {
            return 1;
        }
        
        int count = 0;
        
        // Try placing a queen in each column
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1; // Top-left to bottom-right diagonal index
            int d2 = row + col;         // Top-right to bottom-left diagonal index
            
            // Skip if placing a queen here violates the constraints
            if (columns[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }
            
            // Place the queen
            columns[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;
            
            // Recur for the next row
            count += backtrack(row + 1, n, columns, diagonal1, diagonal2);
            
            // Backtrack: Remove the queen
            columns[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
        
        return count;
    }
}
