class Solution {
    public int maxProfit(int[] prices) {
        int min_so_far = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            min_so_far = Math.min(min_so_far, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min_so_far);
        }

        return maxProfit;
    }
}
