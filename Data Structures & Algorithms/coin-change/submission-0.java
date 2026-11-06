class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];

        // Fill with a value representing impossible/unreachable
        Arrays.fill(dp, amount + 1);

        // Base case
        dp[0] = 0;

        // Calculate minimum coins for every amount
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {

            // Try every coin
            for (int coin : coins) {

                if (coin <= currentAmount) {
                    dp[currentAmount] = Math.min(
                        dp[currentAmount],
                        dp[currentAmount - coin] + 1
                    );
                }
            }
        }

        // If still unreachable
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
