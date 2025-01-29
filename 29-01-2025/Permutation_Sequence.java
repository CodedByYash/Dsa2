import java.util.*;

class Permutation_Sequence {
    public String getPermutation(int n, int k) {
        // Factorial array
        int[] fact = new int[n];
        List<Integer> numbers = new ArrayList<>();
        
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        // List of available numbers
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Convert k to 0-based index
        k--;

        // Build the permutation
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i];
        }
        
        return sb.toString();
    }
}
