class Maximum_Product_Subarray{
	public int maxProduct(int[] A) {
        int currentMin = 1;
        int currentMax = 1;
        int max = 1;
        for(int i = 0;i<A.length();i++){
        	int productWithCurrMax = A[i]*currentMax;
        	int productWithCurrMin = A[i]*currentMin;
        	currentMin = Math.min(A[i],Math.min(productWithCurrMin,productWithCurrMax));
        	currentMax = Math.max(A[i],Math.max(productWithCurrMax,productWithCurrMin));
        	res = Math.max(currentMax,res);
        }
        return res;
    }
}