public class plus_one {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += 1; // Add 1 to the current digit

            if (digits[i] < 10) {
                return digits; // No carry, return immediately
            }

            digits[i] = 0; // Set current digit to 0 and carry over to next
        }

        // If all digits were 9, we need to add a new leading 1
        int[] result = new int[n + 1];
        result[0] = 1; // First element is 1, rest are 0s by default
        return result;
    }
}
