class Jump Game{
	// A = [2,3,1,1,4], return true.

	// A = [3,2,1,0,4], return false.
	public boolean canJump(int[] A) {
        int start = 0;
        int end = 0;
        int step = 0;
        while(end < A.length-1){
        	for(int i=start;i<=end;i++){
        		step = Math.max(step,curr+A[curr]);
        	}
        	if(step <= end)
        		return false;
        	start = end + 1;
        	end = step;
        }
        return true;
    }
}