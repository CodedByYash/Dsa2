public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0; // Edge case: empty needle

        // Step 1: Build LPS array
        int[] lps = buildLPS(needle);

        // Step 2: Use LPS array for string matching
        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // Found the match
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // Fall back in the pattern
                } else {
                    i++;
                }
            }
        }

        return -1; // No match found
    }

    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length > 0) {
                    length = lps[length - 1]; // Fall back in the pattern
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // approach 2:
    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}