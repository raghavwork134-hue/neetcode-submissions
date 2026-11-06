class Solution {

    String s;
    String t;
    long[][] memo;
    
    public int numDistinct(String s, String t) {
        

        this.s = s;
        this.t = t;

        int n = s.length();
        int m = t.length();

        memo = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }

        return (int) dfs(0, 0);
    }

    private long dfs(int i, int j) {

        // Successfully formed t
        if (j == t.length()) {
            return 1;
        }

        // s is finished but t is not
        if (i == s.length()) {
            return 0;
        }

        // Already calculated
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        long ways;

        if (s.charAt(i) == t.charAt(j)) {

            // Choice 1: use s[i]
            // Choice 2: skip s[i]
            ways = dfs(i + 1, j + 1)
                 + dfs(i + 1, j);

        } else {

            // Characters don't match,
            // so skip s[i]
            ways = dfs(i + 1, j);
        }

        memo[i][j] = ways;

        return ways;
    
    }
}
