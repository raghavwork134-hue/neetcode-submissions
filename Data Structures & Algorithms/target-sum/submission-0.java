class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Target is outside the possible range
        if (Math.abs(target) > total) {
            return 0;
        }

        // total + target must be even
        if ((total + target) % 2 != 0) {
            return 0;
        }

        int required = (total + target) / 2;

        int[] dp = new int[required + 1];

        dp[0] = 1;

        for (int num : nums) {

            // Traverse backwards because each number
            // can be used only once.
            for (int s = required; s >= num; s--) {

                dp[s] += dp[s - num];
            }
        }

        return dp[required];
    }
}
