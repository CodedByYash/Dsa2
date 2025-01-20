public class Count_and_say {
    public String countAndSay(int n) {
        // Base case: the first term is "1"
        String result = "1";

        // Generate the sequence up to the nth term
        for (int i = 2; i <= n; i++) {
            StringBuilder nextTerm = new StringBuilder();
            int count = 1;

            // Iterate through the current term
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    // Increment the count if the current digit is the same as the previous
                    count++;
                } else {
                    // Append the count and digit to the next term
                    nextTerm.append(count).append(result.charAt(j - 1));
                    count = 1; // Reset the count
                }
            }

            // Append the last group
            nextTerm.append(count).append(result.charAt(result.length() - 1));

            // Update the result to the next term
            result = nextTerm.toString();
        }

        return result;
    }
}
