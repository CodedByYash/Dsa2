import java.util.HashMap;
import java.util.Map;
public class scrambling_string {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        String key = s1 + "," + s2;
        if (memo.containsKey(key)) return memo.get(key);

        int n = s1.length();
        
        // Quick check: If sorted characters don't match, return false
        if (!isAnagram(s1, s2)) {
            memo.put(key, false);
            return false;
        }
        
        // Try all possible partitions
        for (int i = 1; i < n; i++) {
            // Without swapping
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            
            // With swapping
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }
        
        memo.put(key, false);
        return false;
    }

    private boolean isAnagram(String s1, String s2) {
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) freq[c - 'a']++;
        for (char c : s2.toCharArray()) freq[c - 'a']--;
        for (int count : freq) if (count != 0) return false;
        return true;
    }
}