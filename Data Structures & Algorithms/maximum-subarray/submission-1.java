class Solution {
    public int maxSubArray(int[] nums) {

                        // brute force == , O(n^2)        
        // int sum = 0;
        // int maxSum = Integer.MIN_VALUE;

        // for(int i = 0;i<nums.length;i++){
        //     sum = nums[i];
        //     for(int j = i+1;j<nums.length;j++){
        //         sum += nums[j];
        //     }
        //     maxSum = Math.max(sum,maxSum);
        // }
        // return maxSum;


        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0;i<nums.length;i++){
            curSum += nums[i];

            if(curSum > maxSum){
                maxSum = curSum;
            }

            if(curSum < 0){
                curSum = 0;
            }
        }
        return maxSum;

    }
}
