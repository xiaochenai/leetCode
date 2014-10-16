class Search a 2D Matrix{
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
        	return false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int currCol = 0;
        int currRow = rowLen-1;
        while(currRow >= 0){
        	if(target < matrix[currRow][currCol])
        		currRow--;
        	else{
        		while(currCol < colLen){
        			if(target == matrix[currRow][currCol])
        				return true;
        			else if(target > matrix[currRow][currCol])
        				currCol++;
        			else
        				return false;
        		}
        		return false;
        	}
        }
        return false;
    }
}