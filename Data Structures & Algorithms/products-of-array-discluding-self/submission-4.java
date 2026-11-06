class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // int result[] = new int[nums.length];
        // for(int i = 0;i<nums.length;i++){
        //     int prod = 1; 
        //     for(int j = 0;j<nums.length;j++){
        //         if(i != j){
        //             prod *= nums[j];;
        //         }
        //     }
        //     result[i] = prod;
        // }
        // return result;


                    // 2
        // int n = nums.length;
        // int[] res = new int[n];
        // int[] pref = new int[n];
        // int[] suff = new int[n];

        // pref[0] = 1;
        // suff[n - 1] = 1;
        // for (int i = 1; i < n; i++) {
        //     pref[i] = nums[i - 1] * pref[i - 1];
        // }
        // for (int i = n - 2; i >= 0; i--) {
        //     suff[i] = nums[i + 1] * suff[i + 1];
        // }
        // for (int i = 0; i < n; i++) {
        //     res[i] = pref[i] * suff[i];
        // }
        // return res;


                            // 3
        int n = nums.length;

        int[] result = new int[n];

        // Step 1: Store prefix products
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] = result[i] * suffix;

            suffix *= nums[i];
        }

        return result;
    

    }
}  
