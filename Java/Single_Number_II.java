class Single_Number_II{
    public int singleNumber(int[] A) {
        if(A == null)
        	return null;
        int[] bits = new int[32];
        for(int i=0;i<32;i++){
        	for(int j=0;j<A.length;j++){
        		bits[i] = (bits[i] + ((A[j]>>i) & 1))%3;
        	}
        }
        int res = 0;
        for(int i=0;i<32;i++){
        	res += (bits[i]<<i);
        }
        return res;
    }	
}