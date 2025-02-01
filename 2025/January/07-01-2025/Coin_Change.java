import java.util.Arrays;

public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        // Step 1: Initialize DP array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // Fill with a value larger than the maximum amount
        dp[0] = 0;  // Base case: 0 coins needed for amount 0

        // Step 2: Fill the DP array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // Step 3: Return result
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
