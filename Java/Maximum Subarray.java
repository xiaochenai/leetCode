class Maximum Subarray{
	public int maxSubArray(int[] A) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i:A){
			if(sum < 0)
				sum = 0;
			sum += i;
			max = Math.max(max,sum);
		}
		return max;
	}
}