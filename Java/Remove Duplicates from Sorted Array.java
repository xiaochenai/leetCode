class Remove Duplicates from Sorted Array{
	public int removeDuplicates(int[] A) {
        int curr = 1;
        int pre = 0;
        int len = A.length;
        while(curr < A.length){
        	if(A[curr] == A[pre]){
        		curr++;
        		len--;
        	}
        	else{
        		A[pre+1] = A[curr];
        		pre++;
        		curr++;
        	}
        }
        return len;
    }
}