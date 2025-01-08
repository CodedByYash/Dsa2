import java.util.ArrayList;
import java.util.List;
public class Spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        // Define the boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        // Loop until all boundaries are crossed
        while (top <= bottom && left <= right) {
            // Traverse from left to right (top row)
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++; // Move the top boundary down
            
            // Traverse from top to bottom (right column)
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // Move the right boundary left
            
            // Traverse from right to left (bottom row, if still valid)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // Move the bottom boundary up
            }
            
            // Traverse from bottom to top (left column, if still valid)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // Move the left boundary right
            }
        }
        
        return result;
    }
}
