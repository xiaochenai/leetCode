class Maximal Rectangle{
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] ones = new int[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
        	for(int j=colLen-1;j>=0;j--){
        		if(j == colLen-1)
        			ones[i][j] = matrix[i][j] - '0';
        		else{
        			if(matrix[i][j] == '1')
        				ones[i][j] = 1+ones[i][j+1];
        			else
        				ones[i][j] = 0;
        		}
        	}
        }
        int max = 0;
        int currArea = 0;
        for(int i=0;i<rowLen;i++){
        	for(int j=0;j<colLen;j++){
        		currArea = ones[i][j];
        		int minWidth = ones[i][j];
        		int height = i+1;
        		while(height < rowLen){
        			minWidth = Math.min(minWidth,ones[height][j]);
        			if(minWidth == 0)
        				break;
        			currArea = Math.max(currArea,minWidth*(height-i+1));
        			height++;
        		}
        		max = Math.max(max,currArea);
        	}
        }
        return max;
    }
} 