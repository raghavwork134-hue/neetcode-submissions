class Solution {
    public int minDistance(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        // If word2 is empty,
        // we need to delete all remaining characters from word1.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // If word1 is empty,
        // we need to insert all characters of word2.
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    // Characters already match
                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Replace, Delete, Insert
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1],       // Replace
                        Math.min(
                            dp[i - 1][j],      // Delete
                            dp[i][j - 1]       // Insert
                        )
                    );
                }
            }
        }

        return dp[n][m];
    }
}
