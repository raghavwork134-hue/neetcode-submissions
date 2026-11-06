class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Only one house
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Rob from index 0 to n - 2
        int case1 = robRange(nums, 0, n - 2);

        // Case 2: Rob from index 1 to n - 1
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0; // Best answer till two houses before
        int prev1 = 0; // Best answer till previous house

        for (int i = start; i <= end; i++) {
            int take = nums[i] + prev2;
            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}