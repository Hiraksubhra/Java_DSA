class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxPrice = 0;
        if(n<2){
            return 0;
        }
        for(int i = 1; i<n; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]-minPrice);
        }
        return maxPrice;
    }
}