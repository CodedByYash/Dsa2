import java.util.*;

public class Substring_with_Concatenation_of_All_Words {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        // Step 1: Create a frequency map for words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Step 2: Slide a window over the string
        for (int i = 0; i < wordLen; i++) { // Offset to handle partial overlaps
            int left = i, right = i, count = 0;
            Map<String, Integer> windowCount = new HashMap<>();

            while (right + wordLen <= s.length()) {
                // Get a word from the window
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // If it's a valid word, process it
                if (wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    count++;

                    // If word frequency exceeds the required count, shrink the window
                    while (windowCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If the window matches the total length, add the index
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    // Invalid word, reset the window
                    windowCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}