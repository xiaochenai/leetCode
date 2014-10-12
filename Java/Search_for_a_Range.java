class Search_for_a_Range{
	public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        int start = 0;
        int end = A.length-1;
        while(start < end){
        	int mid = start + (end - start)/2;
        	if(A[mid] < target)
        		start = mid + 1;
        	else
        		end = mid;
        }
        int low = 0;
        if(A[start] != target)
        	return res;
        else
        	low = start;
        start = 0;
        end = A.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target + 1)
                start = mid + 1;
            else
                end = mid;
        }
        int high = A[start] == target ? start : start - 1;
        res[0] = low;
        res[1] = high;
        return res;
    }
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1,-1};
        int start = 0;
        int end = A.length-1;
        int mid = (start+end)/2;
        while(start<=end){
            mid = (start+end)/2;
            if(A[mid] == target){
                res[0]=mid;
                res[1]=mid;
                break;
            }
            if(A[mid] > target){
                end = mid - 1;
            }
            if(A[mid] < target){
                start = mid + 1;
            }
        }
        if(A[mid] != target)
            return res;
        start = mid;
        end = A.length-1;
        while(start<=end){
            int m = (start+end)/2;
            if(A[m] == target)
                start = m + 1;
            else
                end = m-1;
        }
        res[1] = end;
        start = 0;
        end = mid;
        while(start <= end){
            int m = (start+end)/2;
            if(A[m] == target)
                end = m - 1;
            else
                start = m + 1;
        }
        res[0] = start;
        return res;
    }
    public static void main(String[] agrs){
    	Search_for_a_Range s = new Search_for_a_Range();
    	int[] a = {2,2};
    	s.searchRange(a,2);
    }
}