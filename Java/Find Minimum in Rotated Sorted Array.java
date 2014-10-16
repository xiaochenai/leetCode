class Find Minimum in Rotated Sorted Array{
	public int findMin(int[] num) {
        int left = 0;
        int right = num.length-1;
        if(num[left] <= num[right])
            return num[left];
        else{
            int mid = (left+right)/2;
            if(num[mid] >= num[left]){
                while(mid < num.length && num[mid] >= num[left])
                    mid = (mid+1+right)/2;
                while(num[mid-1]<num[mid])
                    mid--;
                return num[mid];
            }
            else{
                while(mid > 0 && num[mid] < num[left])
                    mid = (left+mid-1)/2;
                while(num[mid]<num[mid+1])
                    mid++;
                return num[mid+1];
            }
        }
    }
}