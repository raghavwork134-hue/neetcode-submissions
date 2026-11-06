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


        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 0;i<prices.length;i++){

            minPrice = Math.min(minPrice, prices[i]);

            int profit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;

    }
}
