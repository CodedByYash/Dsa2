public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Iterate through the board to find the starting point
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) { 
                // Start backtracking if first character matches
                    if (backtrack(board, word, 0, r, c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, 
      int index, int row, int col) {
        // Base case: all characters are matched
        if (index == word.length()) {
            return true;
        }

        // Boundary check: out of bounds or character mismatch
        if (row < 0 || row >= board.length || col < 0 || 
          col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four directions
        boolean found = backtrack(board, word, index + 1, row - 1, col) || // Up
                        backtrack(board, word, index + 1, row + 1, col) || // Down
                        backtrack(board, word, index + 1, row, col - 1) || // Left
                        backtrack(board, word, index + 1, row, col + 1);  // Right

        // Restore the cell (backtrack)
        board[row][col] = temp;

        return found;
    }
}
