class Solution {
    public int integerBreak(int n) {
        
        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j < i; j++) {

                // Don't break (i - j) further
                int notBreak = j * (i - j);

                // Break (i - j) further
                int breakFurther = j * dp[i - j];

                dp[i] = Math.max(
                    dp[i],
                    Math.max(notBreak, breakFurther)
                );
            }
        }

        return dp[n];
    }
}