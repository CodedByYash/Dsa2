
public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        int count = 0;

        // Helper function to expand around the center
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes
            count += expandAroundCenter(s, i, i);

            // Even-length palindromes
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
