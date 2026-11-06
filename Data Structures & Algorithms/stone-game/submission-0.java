class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;

        int[][] dp = new int[n][n];

        // Base case:
        // Only one pile is available, so current player takes it.
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Consider intervals of increasing length
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                int takeLeft = piles[i] - dp[i + 1][j];

                int takeRight = piles[j] - dp[i][j - 1];

                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }

        // If Alice can achieve a positive score difference,
        // she wins.
        return dp[0][n - 1] > 0;
    }
}