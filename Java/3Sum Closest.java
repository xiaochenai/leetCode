class 3Sum Closest{
	public int threeSumClosest(int[] num, int target) {
		if(num == null || num.length == 0)
            return 0;
        int sum = 0;
        Arrays.sort(num);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
        	int j = i+1;
        	int k = num.length-1;
        	while(j<k){
        		int a = num[i];
        		int b = num[j];
        		int c = num[k];
        		if(minDiff > Math.abs(a+b+c-target)){
        			minDiff = Math.abs(a+b+c-target);
        			sum = a+b+c;
        		}
        		if(a+b+c > target){
        			while(j < k && num[k] == c){
        				k--;
        			}
        		}
        		else if(a+b+c < target){
        			while(j < k && num[j] == b){
        				j++;
        			}
        		}
        		else{
        			return a+b+c;
        		}
        	}
        }
        return sum;
	}
}