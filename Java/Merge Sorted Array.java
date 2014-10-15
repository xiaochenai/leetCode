class Merge Sorted Array{
	public void merge(int A[], int m, int B[], int n) {
        int index = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0){
        	if(A[i]>B[j]){
        		A[index] = A[i];
        		i--;
        		index--;
        	}
        	else{
        		A[index] = B[j];
        		j--;
        		index--;
        	}
        }
        while(j>=0){
        	A[index] = B[j];
        	index--;
        	j--;
        }
    }
}