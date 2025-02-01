import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    TrieNode root = new TrieNode();

    // Function to insert a word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // Build Trie with words from the wordDict
        for (String word : wordDict) {
            insert(word);
        }

        // Use a memoization map to avoid redundant calculations
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(s, 0, memo);
    }

    private boolean dfs(String s, int index, Map<Integer, Boolean> memo) {
        if (index == s.length()) return true; // Successfully segmented
        if (memo.containsKey(index)) return memo.get(index); // Return cached result

        TrieNode node = root;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) break;

            node = node.children.get(c);
            if (node.isWord) {
                // If we find a valid word, recursively call dfs for the next part of the string
                if (dfs(s, i + 1, memo)) {
                    memo.put(index, true);
                    return true;
                }
            }
        }

        memo.put(index, false); // No valid segmentation found
        return false;
    }
}
