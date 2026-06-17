class Solution {
    public int maxProfit(int[] prices) {
        int min_so_far = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min_so_far);
            min_so_far = Math.min(min_so_far, prices[i]); 
        }

        return maxProfit;
    }
}
