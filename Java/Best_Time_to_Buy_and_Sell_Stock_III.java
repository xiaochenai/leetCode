class Best_Time_to_Buy_and_Sell_Stock_III{
	public int maxProfit(int[] prices) {
        
    }
    //go through from left to right
    //find the max profit for a[0,i]
    //then the maxprofit for a[0,i+1] = max(a[0,i],a[i+1]-min);
    //similar process, scan from right to left
    //find max profit for a[i,a.length-1];
    //find the maxprofit of all combination of left and right
    private int linearSolution(int[] prices){
    	if (prices == null || prices.length == 0) {  
            return 0;  
        }  
        int n = prices.length;  
        int[] left = new int[n];  
        int[] right = new int[n];  
        int min = prices[0];  
        for (int i = 1; i < n; i++) {  
            left[i] = left[i - 1] > prices[i] - min ? left[i - 1] : prices[i] - min;  
            min = min < prices[i] ? min : prices[i];  
        }  
        int max = prices[n - 1];  
        for (int i = n - 2; i >= 0; i--) {  
            right[i] = right[i + 1] > max - prices[i] ? right[i + 1] : max - prices[i];  
            max = max > prices[i] ? max : prices[i];  
        }  
        int value = 0;  
        for (int i = 0; i < n; i++) {  
            value = value > left[i] + right[i] ? value : left[i] + right[i];  
        }  
        return value;   
    }
    private int bruteForceSolution(int[] prices){

    }
    private int oneTrans(int[] prices){
    	int max = Integer.MAX_VALUE;
    	int currMin = prices[0];
    	int index = 0;
    	for(int i=1;i<prices.length;i++){
    		int diff = prices[i] - currMin;
    		if(currMin > prices[i])
    			currMin = prices[i];
    		max = Math.max(max,diff);
    	}
    }
}