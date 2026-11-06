class Solution {
    public int numSquares(int n) {
        
        int[] dp = new int[n + 1];

        // dp[0] = 0
        // For all other values, initialize with a large number.
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                dp[i] = Math.min(
                    dp[i],
                    dp[i - square] + 1
                );
            }
        }

        return dp[n];
    }
}