class Multiply_strings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0"; // If either number is 0, the product is 0
        }

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n]; // Array to store intermediate results

        // Step 1: Multiply each digit
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // Multiply digits
                int sum = mul + result[i + j + 1]; // Add to existing value at the position

                result[i + j + 1] = sum % 10; // Store the single digit
                result[i + j] += sum / 10; // Carry to the next position
            }
        }

        // Step 2: Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
