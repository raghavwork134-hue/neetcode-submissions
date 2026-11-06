class Solution {
    public int maxProfit(int[] prices) {
        
        int maxprofit = 0;
        int bp = Integer.MAX_VALUE;
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
