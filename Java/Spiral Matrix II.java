class Spiral Matrix II{
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int bot = n-1;
        int left = 0;
        int right = n-1;
        int num = 1;
        while(top < bot && left < right){
        	for(int i=left;i<right;i++){
        		res[top][i] = num++;
        	}
        	for(int i=top;i<bot;i++){
        		res[i][right] = num++;
        	}
        	for(int i=right;i>left;i--){
        		res[bot][i] = num++;
        	}
        	for(int i=bot;i>top;i--){
        		res[i][left] = num++;
        	}
        	left++;
        	right--;
        	top++;
        	bot--;
        }
        if(bot == top && left == right){
        	res[top][left] = num++;
        }
        else if(bot != top && left == right){
        	for(int i = top;i<=bot;i++){
        		res[i][left] = num++;
        	}
        }
        else if(bot == top && left != right){
        	for(int i=left;i<=right;i++){
        		res[top][i] = num++;
        	}
        }
        return res;
    }
} 