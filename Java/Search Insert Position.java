class Search Insert Position{
	public int searchInsert(int[] A, int target) {
		if(target <= A[0])
			return 0;
			
        for(int i=1;i<A.length;i++){
        	if(target > A[i-1] && target <= A[i])
        		return i;
        }
        return A.length;
    }
}