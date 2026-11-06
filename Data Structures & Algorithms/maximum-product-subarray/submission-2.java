class Solution {
    public int maxProduct(int[] nums) {
        
                                // brute force
        // int res = nums[0];

        // for (int i = 0; i < nums.length; i++) {
        //     int cur = nums[i];
        //     res = Math.max(res, cur);
        //     for (int j = i + 1; j < nums.length; j++) {
        //         cur *= nums[j];
        //         res = Math.max(res, cur);
        //     }
        // }

        // return res;


                        // kadane algo
         int res = nums[0];
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
