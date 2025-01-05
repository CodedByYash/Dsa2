import java.util.*;

public class largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        // Add a zero-height bar at the end
        int[] extendedHeights = Arrays.copyOf(heights, n + 1);

        for (int i = 0; i < extendedHeights.length; i++) {
            while (!stack.isEmpty() && extendedHeights[stack.peek()] > extendedHeights[i]) {
                // Pop the top index
                int height = extendedHeights[stack.pop()];

                // Calculate the width
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // Update max area
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
