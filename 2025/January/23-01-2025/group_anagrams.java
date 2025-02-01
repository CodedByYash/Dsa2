import java.util.*;

class group_anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to group anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Generate the frequency count key
            int[] count = new int[26]; // Assuming only lowercase letters
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append("#");
                sb.append(num);
            }
            String key = sb.toString();
            
            // Add the string to the corresponding group in the map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        // Return all grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
