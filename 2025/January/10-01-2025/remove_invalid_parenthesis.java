import java.util.*;

class remove_invalid_parenthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null)
            return result;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // If we found a valid string, stop generating further strings
            if (found)
                continue;

            // Generate all possible substrings by removing one character
            for (int i = 0; i < current.length(); i++) {
                // Only remove parentheses
                if (current.charAt(i) != '(' && current.charAt(i) != ')')
                    continue;

                String next = current.substring(0, i) + current.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return result;
    }

    // Helper method to check if a string is valid
    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(')
                count++;
            if (c == ')')
                count--;
            if (count < 0)
                return false; // More closing parentheses than opening
        }
        return count == 0; // Valid if no unmatched opening parentheses remain
    }
}
