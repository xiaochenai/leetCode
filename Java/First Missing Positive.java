class First Missing Positive{
	public int firstMissingPositive(int[] A) {
		if(A == null || A.length == 0)
            return 1;
        for(int i=0;i<A.length;i++){
        	while(A[i]>0 && A[i]<A.length && A[i] != A[A[i]-1]){
        		int temp = A[i];
        		A[i] = A[temp-1];
        		A[temp-1] = temp;
        	}
        		
        	
        }
        for(int i=0;i<A.length;i++){
        	if(A[i] != i+1)
        		return i+1;
        }
        return A.length+1;

	}
}