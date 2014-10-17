class Spiral Matrix{
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
       		return res;
       	int top = 0;
       	int bot = matrix.length-1;
       	int left = 0;
       	int right = matrix[0].length-1;
       	while(top < bot && left < right){
       		for(int i=left;i<right;i++){
       			res.add(matrix[top][i]);
       		}
       		for(int i=top;i<bot;i++){
       			res.add(matrix[i][right]);
       		}
       		for(int i=right;i>left;i--){
       			res.add(matrix[bot][i]);
       		}
       		for(int i=bot;i>top;i--){
       			res.add(matrix[i][left]);
       		}
       		left++;
       		right--;
       		top++;
       		bot--;
       	}
       	if(top == bot && left == right){
            res.add(matrix[top][left]);
        }
        else if(top == bot && left != right){
        	for(int i=left;i<=right;i++){
        		res.add(matrix[top][i]);
        	}
        }
        else if(top != bot && left == right){
        	for(int i=top;i<=bot;i++){
        		res.add(matrix[i][left]);
        	}
        }
        return res;
    }
}