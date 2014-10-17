class Trapping Rain Water{
	public int trap(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int left = 0;
        int right = A.length - 1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (left < right){
            min = Math.min(A[left],A[right]);
            if(A[left] == min){
                left++;
                while(A[left] < min && left < right){
                    sum = sum + min - A[left];
                    left++;
                }
            }
            else{
                right--;
                while(A[right] < min && left < right){
                    sum = sum + min - A[right];
                    right--;
                }
            }
        }
        return sum;
    }
}