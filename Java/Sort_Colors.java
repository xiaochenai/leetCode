class Sort_Colors{
	// we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	// the colors in the order red, white and blue
	//couting sort or bucket sort
	public void sortColors(int[] A) {
        if(A == null || A.length == 0)
            return;
        int[] color = new int[3];
        for(int i:A){
        	color[i] += 1;
        }
        int index = 0;
        for(int i=0;i<color.length;i++){
        	while(color[i]>0){
        		A[index] = i;
        		index++;
        		color[i] = color[i] - 1;
        	}
        }
    }
    //inplace version
    public void sortColors(int[] A){
        if(A == null || A.length == 0)
            return;
        int start = 0, end = A.length-1;
        int i=0;
        while(i < A.length){
            if(i > end)
                break;
            if(A[i] == 2){
                int temp = A[i];
                A[i] = A[end];
                A[end] = temp;
                end--;
            }
            else if(A[i] == 0){
                int temp = A[i];
                A[i] = A[start];
                A[start] = temp;
                start++;
                i++;
            }
            else
                i++;
        }
    }
    public static void main(String[] args){
    	Sort_Colors s = new Sort_Colors();
    	int[] a = {0};
    	s.sortColors(a);

    }
}