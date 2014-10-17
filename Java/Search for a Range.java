class Search for a Range{
	public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        int start = 0;
        int end = A.length-1;
        int mid = (start+end)/2;
        while(start<=end){
        	mid = (start+end)/2;
            if(A[mid] == target)
                break;
            else if(A[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        if(A[mid] != target)
            return res;
        start = 0;
        end = mid;
        while(start<=end){
            int cmid = (start+end)/2;
            if(A[cmid]>=target){
                end = cmid - 1;
            }
            else{
                start = cmid + 1;
            }
        }
        res[0] = start;
        start = mid;
        end = A.length-1;
        while(start<=end){
            int cmid = (start+end)/2;
            if(A[cmid]<=target){
                start = cmid + 1;
            }
            else{
                end = cmid - 1;
            }
        }
        res[1] = end;
        return res;
    }
}