class decode_ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0; // No valid decoding for empty string or starting with '0'
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // Empty string has one valid decoding
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        // Dynamic programming to fill the dp array
        for (int i = 2; i <= n; i++) {
            // Single digit decoding
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Double digit decoding
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
