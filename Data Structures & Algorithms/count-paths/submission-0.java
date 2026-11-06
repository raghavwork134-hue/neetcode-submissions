class Solution {
    public int uniquePaths(int m, int n) {

        int[] dp = new int[n];
        
        // There is exactly one way to reach every cell
        // in the first row.
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}
