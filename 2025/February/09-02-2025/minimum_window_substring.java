import java.util.*;

public class minimum_window_substring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int required = charFreq.size(); // Number of unique characters to match
        int matched = 0; // Characters matched so far
        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (charFreq.containsKey(c) && windowCounts.get(c).equals(charFreq.get(c))) {
                matched++;
            }

            while (matched == required) { // Try to shrink window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

                if (charFreq.containsKey(leftChar) && windowCounts.get(leftChar) < charFreq.get(leftChar)) {
                    matched--; // Lost a required character
                }
                left++;
            }
            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
    }
}