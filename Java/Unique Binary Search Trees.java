class Unique Binary Search Trees{
	//1......i....n
	//for root(i) the number of tree is num(1....i-1)*num(i+1....n)
	//so for 1....m
	//need to calc the tree with root 1....n
	public int numTrees(int n) {
		int[] dp = new int[n+1];
		if(n==0 || n==1)
			return 1;
		dp[0] = 1;
		for(int i=1;i<=n;i++){
			for(int j=0;j<i;j++){
				dp[i] = dp[i] + dp[j]*dp[i-j-1];
			}
		}
		return dp[n];
	}
}