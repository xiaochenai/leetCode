class Remove Element{
	public int removeElement(int[] A, int elem) {
        int newLen = A.length;
        for(int i=0;i<newLen;i++){
        	if(A[i] == elem){
        		while(newLen>i+1 && A[newLen-1] == elem){
        			newLen--;
        		}
        		A[i] = A[newLen-1];
        		newLen--;
        		if(newLen <= i)
        			break;
        	}
        }
        int[] newA = Arrays.copyOf(A,newLen);
        return newLen;
    }
}