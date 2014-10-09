class RotateImage{
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return;
        int rowNum = matrix.length;
        for(int i=0;i<rowNum/2;i++){
        	for(int j=0;j<Math.ceil((float)rowNum/2.0);j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[rowNum-j-1][i];
        		matrix[rowNum-j-1][i] = matrix[rowNum-i-1][rowNum-j-1];
        		matrix[rowNum-i-1][rowNum-j-1] = matrix[j][rowNum-i-1];
        		matrix[j][rowNum-i-1] = temp;
        	}
        }
    }
    
}