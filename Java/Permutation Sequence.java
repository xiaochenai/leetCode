class Permutation Sequence{
	public String getPermutation(int n, int k) {
		int[] num = new int[n];
		int total = 1;
		for(int i=1;i<=n;i++){
			num[i-1] = i;
			total = total*i;
		}
		k = k - 1;
        String res = "";
        for(int i=0;i<n;i++){
        	total = total/(n-i);
        	int index = k/total;
        	k = k % total;
        	res = res + num[index];
        	for(int j=index;j<n-1;j++){
        		num[j] = num[j+1];
        	}
        }
        return res;
	}
}