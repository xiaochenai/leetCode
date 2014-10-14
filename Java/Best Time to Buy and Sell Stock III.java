class Best Time to Buy and Sell Stock III{
	    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        //0-i
        int min = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
        	int curr = prices[i] - min;
        	if(prices[i]<min)
        		min = prices[i];
        	max = Math.max(curr,max);
        	left[i]=max;
        }
        //i-end
        int maxPrice = prices[prices.length-1];
        max = 0;
        for(int i=prices.length-2;i>=0;i--){
        	int curr = maxPrice - prices[i];
        	if(prices[i] > maxPrice)
        		maxPrice = prices[i];
        	max = Math.max(curr,max);
        	right[i] = max;
        }
        max = 0;
        for(int i=0;i<prices.length;i++){
        	max = Math.max(max,left[i]+right[i]);
        }
        return max;
    }
}