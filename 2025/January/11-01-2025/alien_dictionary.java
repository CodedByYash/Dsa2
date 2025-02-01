import java.util.*;

public class alien_dictionary {

    class Solution {
        public String alienOrder(String[] words) {
            // Step 1: Initialize the graph and in-degree map
            Map<Character, List<Character>> graph = new HashMap<>();
            Map<Character, Integer> inDegree = new HashMap<>();

            for (String word : words) {
                for (char c : word.toCharArray()) {
                    graph.putIfAbsent(c, new ArrayList<>());
                    inDegree.putIfAbsent(c, 0);
                }
            }

            // Step 2: Build the graph
            for (int i = 0; i < words.length - 1; i++) {
                String word1 = words[i];
                String word2 = words[i + 1];
                if (word1.length() > word2.length() && word1.startsWith(word2)) {
                    return ""; // Invalid order
                }

                int minLength = Math.min(word1.length(), word2.length());
                for (int j = 0; j < minLength; j++) {
                    if (word1.charAt(j) != word2.charAt(j)) {
                        char from = word1.charAt(j);
                        char to = word2.charAt(j);
                        graph.get(from).add(to);
                        inDegree.put(to, inDegree.get(to) + 1);
                        break;
                    }
                }
            }

            // Step 3: Perform topological sort
            Queue<Character> queue = new LinkedList<>();
            for (char c : inDegree.keySet()) {
                if (inDegree.get(c) == 0) {
                    queue.offer(c);
                }
            }

            StringBuilder result = new StringBuilder();
            while (!queue.isEmpty()) {
                char current = queue.poll();
                result.append(current);

                for (char neighbor : graph.get(current)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }

            // If result length doesn't match the graph size, there's a cycle
            if (result.length() != graph.size()) {
                return "";
            }

            return result.toString();
        }
    }

}
