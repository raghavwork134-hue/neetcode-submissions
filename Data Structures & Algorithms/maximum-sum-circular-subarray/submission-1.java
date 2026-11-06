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
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int minCurSum = 0;
        int minSum = Integer.MAX_VALUE;

        int totalSum = 0;

        for(int i = 0; i < nums.length; i++) {

            // Total sum
            totalSum += nums[i];

            // Normal Kadane - maximum subarray
            curSum += nums[i];

            if(curSum > maxSum) {
                maxSum = curSum;
            }

            if(curSum < 0) {
                curSum = 0;
            }


            // Minimum Kadane - minimum subarray
            minCurSum += nums[i];

            if(minCurSum < minSum) {
                minSum = minCurSum;
            }

            if(minCurSum > 0) {
                minCurSum = 0;
            }
        }

        // All elements are negative
        if(maxSum < 0) {
            return maxSum;
        }

        // Circular maximum
        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }
}