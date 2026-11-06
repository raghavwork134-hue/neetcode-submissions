class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
                    // brute force
        // int n = nums.length;
        // int res = nums[0];

        // for (int i = 0; i < n; i++) {
        //     int curSum = 0;
        //     for (int j = i; j < i + n; j++) {
        //         curSum += nums[j % n];
        //         res = Math.max(res, curSum);
        //     }
        // }

        // return res;


                        // optimised
        // int curSum = 0;
        // int maxSum = Integer.MIN_VALUE;

        // int minCurSum = 0;
        // int minSum = Integer.MAX_VALUE;

        // int totalSum = 0;

        // for(int i = 0; i < nums.length; i++) {

        //     // Total sum
        //     totalSum += nums[i];

        //     // Normal Kadane - maximum subarray
        //     curSum += nums[i];

        //     if(curSum > maxSum) {
        //         maxSum = curSum;
        //     }

        //     if(curSum < 0) {
        //         curSum = 0;
        //     }


        //     // Minimum Kadane - minimum subarray
        //     minCurSum += nums[i];

        //     if(minCurSum < minSum) {
        //         minSum = minCurSum;
        //     }

        //     if(minCurSum > 0) {
        //         minCurSum = 0;
        //     }
        // }

        // // All elements are negative
        // if(maxSum < 0) {
        //     return maxSum;
        // }

        // // Circular maximum
        // int circularSum = totalSum - minSum;

        // return Math.max(maxSum, circularSum);


                    // OR 
        int curMaxSum = 0, maxSum = -Integer.MAX_VALUE;
        int curMinSum = 0, minSum = Integer.MAX_VALUE;
        int total = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            curMaxSum = Math.max(curMaxSum + nums[i], nums[i]);
            curMinSum = Math.min(curMinSum + nums[i], nums[i]);

            total += nums[i];

            maxSum = Math.max(maxSum, curMaxSum);
            minSum = Math.min(minSum, curMinSum);
        }

        return Math.max(maxSum, total != minSum ? total - minSum : -Integer.MAX_VALUE);
        
    }
}