class Best Time to Buy and Sell Stock II{
	public int maxProfit(int[] prices) {
		int max = 0;
		if(prices == null || prices.length == 0)
            return 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>prices[-1]){
				max+=prices[i]-prices[i-1];
			}
		}
		return max;
	}
}