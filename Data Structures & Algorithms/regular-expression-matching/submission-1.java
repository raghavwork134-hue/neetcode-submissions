class Solution {
    public boolean isMatch(String s, String p) {
        
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= m; j++) {

            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                boolean firstMatch =
                    sChar == pChar || pChar == '.';

                if (pChar == '*') {

                    // Option 1: '*' matches zero characters
                    dp[i][j] = dp[i][j - 2];

                    // Option 2: '*' matches one or more characters
                    if (firstMatchOfPrevious(s, p, i, j)) {
                        dp[i][j] =
                            dp[i][j]
                            || dp[i - 1][j];
                    }

                } else if (firstMatch) {

                    // Normal character or '.'
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }

    private boolean firstMatchOfPrevious(String s,String p,int i,int j
    ) {

        char sChar = s.charAt(i - 1);
        char prevPatternChar = p.charAt(j - 2);

        return sChar == prevPatternChar
            || prevPatternChar == '.';
    
    }
}
