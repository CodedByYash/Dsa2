public class Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        // Step 1: Initialize frequency array and variables
        int[] count = new int[26]; // To store frequency of characters
        int left = 0, maxFreq = 0, maxLength = 0;

        // Step 2: Sliding window
        for (int right = 0; right < s.length(); right++) {
            // Increment the frequency of the current character
            count[s.charAt(right) - 'A']++;

            // Update maxFreq (most frequent character in the current window)
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // Check if the window is valid
            while ((right - left + 1) - maxFreq > k) {
                // Shrink the window from the left
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
