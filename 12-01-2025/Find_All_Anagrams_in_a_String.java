import java.util.*;

public class Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;

        // Step 1: Initialize character counts for p
        int[] countP = new int[26];
        int[] countWindow = new int[26];

        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        // Step 2: Sliding window over s
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            // Add the current character to the window
            countWindow[s.charAt(right) - 'a']++;

            // If the window size exceeds p.length, shrink it
            if (right - left + 1 > p.length()) {
                countWindow[s.charAt(left) - 'a']--;
                left++;
            }

            // Compare the two frequency arrays
            if (Arrays.equals(countP, countWindow)) {
                result.add(left);
            }

            right++;
        }

        return result;
    }
}
