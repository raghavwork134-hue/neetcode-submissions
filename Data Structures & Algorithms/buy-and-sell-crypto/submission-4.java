class Solution {
    public int maxProfit(int[] prices) {
        
        // int maxProfit = 0;

        // for(int i = 0;i<prices.length;i++){
        //     for(int j = i+1;j<prices.length;j++){
        //         if(prices[j] - prices[i] > maxProfit){
        //             maxProfit = prices[j] - prices[i];
        //         }
        //     }
        // }
        // return maxProfit;


        // int minPrice = prices[0];
        // int maxProfit = 0;

        // for(int i = 0;i<prices.length;i++){

        //     minPrice = Math.min(minPrice, prices[i]);

        //     int profit = prices[i] - minPrice;

        //     maxProfit = Math.max(maxProfit, profit);
        // }

        // return maxProfit;    

                    // OR , the above code is same as below code

        // int bp = prices[0];
        // int maxprofit = 0;
        // for(int i = 1;i<prices.length;i++){
        //     if(bp < prices[i]){
        //         int profit = prices[i] - bp;
        //         maxprofit = Math.max(profit,maxprofit);
        //     }
        //     else{
        //         bp = prices[i];
        //     }
        // }
        // return maxprofit;

        int bp = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0;i<prices.length;i++){
            if(bp < prices[i]){
                int profit = prices[i] - bp;
                maxprofit = Math.max(profit,maxprofit);
            }
            else{
                bp = prices[i];
            }
        }
        return maxprofit;

    }
}
