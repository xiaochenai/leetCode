class Search in Rotated Sorted Array{
	public int search(int[] A, int target) {
        if(A == null || A.length == 0)
        	return -1;
        int l = 0;
        int r = A.length-1;
        while(l<=r){
        	int mid = (l+r)/2;
        	if(A[mid] == target)
        		return mid;
        	//mid > left
        	else if(A[mid] > A[l]){
        		if(A[mid] > target && target <= A[r])
        			l = mid + 1;
        		else if(A[mid] > target && target >= A[l])
        			r = mid - 1;
        		else if(A[mid] < target && target >= A[l])
        			l = mid + 1;

        	}
        	//mid < left
        	else if(A[mid] < A[i]){
        		if(A[mid] < target && target <= A[r])
        			l = mid + 1;
        		else if(A[mid] < target && target >= A[l])
        			r = mid - 1;
        		else if(A[mid] > target && target <= A[r])
        			r= mid - 1;
        	}
        	else
        		l++;
        }
        return -1;
    }
}