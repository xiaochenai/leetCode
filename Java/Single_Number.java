class Single_Number{
    public int singleNumber(int[] A) {
    	int res = 0;
        for(int i:A){
        	res = res ^ i;
        }
        return res;
    }	
    public int singleNumber(int[] A) {
    	int[] bits = new int[32];
    	for(int i=0;i<32;i++){
    		for(int j:A){
    			bits[i] += (j>>i & 1);
    		}
    	}
    	int res = 0;
    	for(int i=0;i<32;i++){
    		bits[i] = bits[i]%2;
    		res = res + (bits[i]<<i);
    	}
    	return res;
    }	
}