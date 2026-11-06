class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;

        // Add boundary balloons with value 1
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[left][right] =
        // maximum coins from bursting balloons
        // strictly between left and right
        int[][] dp = new int[n + 2][n + 2];

        // Length is the distance between left and right.
        // We need at least one balloon between them.
        for (int len = 2; len <= n + 1; len++) {

            for (int left = 0;
                 left + len < n + 2;
                 left++) {

                int right = left + len;

                // Try every balloon as the last balloon
                for (int k = left + 1;
                     k < right;
                     k++) {

                    int coins =
                        dp[left][k]
                        + arr[left] * arr[k] * arr[right]
                        + dp[k][right];

                    dp[left][right] =
                        Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}
