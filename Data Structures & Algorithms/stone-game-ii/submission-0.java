class Solution {
    
    int n;
    int[][] memo;
    int[] suffix;

    public int stoneGameII(int[] piles) {
    
        n = piles.length;

        memo = new int[n][n + 1];
        suffix = new int[n + 1];

        // suffix[i] = total stones from i to n-1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return dfs(0, 1);
    }

    private int dfs(int i, int M) {

        // All piles have been taken
        if (i >= n) {
            return 0;
        }

        // If we can take all remaining piles
        if (2 * M >= n - i) {
            return suffix[i];
        }

        // Already calculated
        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int best = 0;

        // Try taking X piles
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int opponent = dfs(
                i + X,
                Math.max(M, X)
            );

            int currentScore = suffix[i] - opponent;

            best = Math.max(best, currentScore);
        }

        memo[i][M] = best;

        return best;
    }
    
}