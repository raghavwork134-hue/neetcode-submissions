class Solution {
    public boolean canPartition(int[] nums) {
         int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Equal partition is impossible if total sum is odd
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];

        // Sum 0 is always possible
        dp[0] = true;

        for (int num : nums) {

            // Go backwards to avoid using the same number twice
            for (int j = target; j >= num; j--) {

                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[target];
    }
}
