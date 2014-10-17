class Jump Game II{
	public int jump(int[] A) {
        int start = 0;
        int end = 0;
        int minStep = 0;
        int currMax = 0;
        if(A == null || A.length == 0 || A.length == 1)
        	return 0;
        if(A[0] > A.length-1)
        	return 1;
        while(end<A.length){
        	minStep++;
        	for(int i=start;i<=end;i++){
        		if(i+A[i]>=A.length-1)
        			return minStep;
        		currMax = Math.max(currMax,A[i]+i);
        	}
        	start = end + 1;
        	end = currMax;
        }
        return minStep;
    }
}