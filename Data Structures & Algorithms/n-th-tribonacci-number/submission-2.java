class Solution {
    public int tribonacci(int n) {
        
        // if(n == 0){
        //     return 0;
        // }

        // if(n == 1 || n == 2){
        //     return 1;
        // }

        // int dp[] = new int[n + 1];

        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 1;

        // for(int i = 3;i<=n;i++){
        //     dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        // }

        // return dp[n];

                    // space optimised
        if(n == 0){
            return 0;
        }

        if(n == 1 || n == 2){
            return 1;
        }

        int prev3 = 0;
        int prev2 = 1;
        int prev1 = 1;

        for(int i = 3;i<=n;i++){
            int current = prev3 + prev2 + prev1;

            prev3 = prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;

    }
}