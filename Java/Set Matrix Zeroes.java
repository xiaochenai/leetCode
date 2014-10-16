class Set Matrix Zeroes{
	public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        	return;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int rowZero = 0;
        int colZero = 0;
        for(int i=0;i<colLen;i++){
        	if(matrix[0][i] == 0){
        		rowZero = 1;
        		break;
        	}
        }
        for(int i=0;i<rowLen;i++){
        	if(matrix[i][0] == 0){
        		colZero = 1;
        		break;
        	}
        }
        for(int i=0;i<rowLen;i++){
        	for(int j=0;j<colLen;j++){
        		if(matrix[i][j] == 0){
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        for(int i=1;i<rowLen;i++){
        	for(int j=1;j<colLen;j++){
        		if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
        	}
        }
        if(colZero == 1){
        	for(int i=0;i<rowLen;i++)
        		matrix[i][0] = 0;
        }
        if(rowZero == 1){
        	for(int i=0;i<colLen;i++)
        		matrix[0][i] = 0;
        }
    }
}