import java.util.*;

public class word_ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        // Create a queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Check all possible transformations
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String transformedWord = new String(wordArray);

                        // If we reach the endWord
                        if (transformedWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If transformedWord is in the wordList and not visited
                        if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                            visited.add(transformedWord);
                            queue.add(transformedWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
