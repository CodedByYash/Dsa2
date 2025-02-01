import java.util.ArrayList;
import java.util.List;

public class word_Search2 {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                backtrack(board, r, c, root, result);
            }
        }

        return result;
    }

    private void backtrack(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        TrieNode child = node.children[ch - 'a'];
        if (child == null) {
            return;
        }

        if (child.word != null) {
            result.add(child.word);
            child.word = null; // Avoid duplicate results
        }

        // Mark as visited
        board[r][c] = '#';

        // Explore neighbors
        backtrack(board, r - 1, c, child, result); // Up
        backtrack(board, r + 1, c, child, result); // Down
        backtrack(board, r, c - 1, child, result); // Left
        backtrack(board, r, c + 1, child, result); // Right

        // Revert the cell
        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }
}