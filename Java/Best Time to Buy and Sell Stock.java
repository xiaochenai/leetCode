class Best Time to Buy and Sell Stock{
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            int diff = prices[i] - min;
            min = Math.min(min,prices[i]);
            max = Math.max(max,diff);
        }
        return max;
    }
}