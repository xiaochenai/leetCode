class Remove Duplicates from Sorted Array II{
	public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)
        	return 0;
        int len = A.length;
        int twice = 0;
        int pre = 0;
        int curr = 1;
        while(curr < A.length){
        	if(A[curr] != A[pre]){
        		A[pre+1] = A[curr];
        		curr++;
        		pre++;
        		twice = 0;
        	}
        	else if(A[curr] == A[pre] && twice == 0){
        		twice = 1;
        		A[pre+1] = A[curr];
        		pre++;
        		curr++;
        	}
        	else{
        		len--;
        		curr++;
        	}
        }
        int[] newA = Arrays.copyOfRange(A,0,len);
        return len;
    }
}