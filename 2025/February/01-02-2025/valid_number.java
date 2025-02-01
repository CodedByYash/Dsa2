public class valid_number {
    public boolean isNumber(String s) {
        s = s.trim(); // Remove leading/trailing spaces
        boolean seenDigit = false, seenDot = false, seenE = false;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Case 1: Digit (Valid in all situations)
            if (Character.isDigit(c)) {
                seenDigit = true;
            
            // Case 2: Dot `.`
            } else if (c == '.') {
                if (seenDot || seenE) return false; // Can't have multiple dots or dot after `e`
                seenDot = true;
            
            // Case 3: `e` or `E` (Scientific Notation)
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit) return false; // Can't have multiple `e` or `e` without prior digits
                seenE = true;
                seenDigit = false; // Reset to check digits after `e`
            
            // Case 4: Sign (`+` or `-`)
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false; // Sign only at start or after `e`
            
            // Case 5: Invalid Character
            } else {
                return false;
            }
        }
        
        return seenDigit; // Must have at least one digit
    }
}
