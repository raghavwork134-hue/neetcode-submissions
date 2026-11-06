class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));

        int n = s.length();
        int[] dp = new int[n + 1];

        // Base case
        dp[n] = 0;

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Option 1: s[i] is an extra character
            dp[i] = 1 + dp[i + 1];

            // Option 2: Try every substring starting at i
            for (int j = i; j < n; j++) {
                String word = s.substring(i, j + 1);

                if (set.contains(word)) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
    
    }
}