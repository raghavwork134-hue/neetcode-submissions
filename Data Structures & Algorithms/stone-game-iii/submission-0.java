class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        int[] dp = new int[n + 1];

        // dp[n] = 0 because no stones remain

        for (int i = n - 1; i >= 0; i--) {

            int take = 0;
            dp[i] = Integer.MIN_VALUE;
            // Try taking 1, 2, or 3 stones
            for (int k = 1; k <= 3 && i + k <= n; k++) {

                take += stoneValue[i + k - 1];

                dp[i] = Math.max(
                    dp[i],
                    take - dp[i + k]
                );
            }
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}