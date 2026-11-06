class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {

            // Add the new index entering the window
            int add = i - minJump;

            if (add >= 0 && dp[add]) {
                reachableCount++;
            }

            // Remove the index leaving the window
            int remove = i - maxJump - 1;

            if (remove >= 0 && dp[remove]) {
                reachableCount--;
            }

            // Current index is reachable if:
            // 1. It is '0'
            // 2. There is at least one reachable index
            //    in the valid jump range
            if (s.charAt(i) == '0' && reachableCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    
    }
}