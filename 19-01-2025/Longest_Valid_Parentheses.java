import java.util.*;

public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        // Stack to store indices
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for valid substrings

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Push the index of '('
            } else {
                stack.pop(); // Pop the top index for ')'

                if (stack.isEmpty()) {
                    stack.push(i); // Update base index for invalid ')'
                } else {
                    // Calculate the length of the valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}