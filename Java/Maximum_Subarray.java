class Maximum_Subarray{
	    public int maxSubArray(int[] A) {
        int max = A[0];
        int curr =A[0];
        for(int i=1;i<A.length;i++){
        	if(curr < 0)
        		curr = 0;
        	curr = curr + A[i];
        	max = Math.max(curr,max);
        }
        return max;
    }
}