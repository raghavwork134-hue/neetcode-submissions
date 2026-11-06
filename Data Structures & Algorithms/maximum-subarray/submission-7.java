class Solution {
    public int maxSubArray(int[] nums) {

        // int currentSum = nums[0];
        // int maxSum = nums[0];

        // for (int i = 1; i < nums.length; i++) {

        //     currentSum = Math.max(nums[i], currentSum + nums[i]);

        //     maxSum = Math.max(maxSum, currentSum);
        // }

        // return maxSum;

                                // or
        int maxSub = nums[0], curSum = 0;
        for (int num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;


                                // brute
        // int n = nums.length, res = nums[0];
        // for (int i = 0; i < n; i++) {
        //     int cur = 0;
        //     for (int j = i; j < n; j++) {
        //         cur += nums[j];
        //         res = Math.max(res, cur);
        //     }
        // }
        // return res;
    }
}