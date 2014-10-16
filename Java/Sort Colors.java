class Sort Colors{
	//0, 1, and 2 to represent the color red, white, and blue respectively.
	public void sortColors(int[] A) {
        if(A == null || A.length == 0)
        	return;
        int[] color = new int[3];
        for(int i:A){
        	color[i] = color[i]+1;
        }
        int index = 0;
        for(int i=0;i<A.length;i++){
        	if(color[index] == 0)
        		index++;
        	A[i] = index;
        	color[index]--;
        }
    }	
}