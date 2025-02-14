import java.util.Stack;

public class maximum_rectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n]; // Histogram heights
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            // Step 1: Update heights array
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1; // Increase height
                } else {
                    heights[j] = 0; // Reset height
                }
            }

            // Step 2: Compute max rectangle area for this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // Function to find the largest rectangle area in a histogram
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}