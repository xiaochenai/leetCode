class Rotate Image{
	public void rotate(int[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
        int[][] newMatrix = new int[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
        	for(int j=0;j<colLen;j++){
        		newMatrix[i][j] = matrix[j][rowLen-i-1];
        	}
        }
        return newMatrix;
    }
    public void rotate(int[][] matrix) {
    	int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for(int i=0;i<rowLen/2;i++){
			for(int j=0;j<Math.ceil((float)(rowLen)/2);j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[rowLen-j-1][i];
				matrix[rowLen-j-1][i] = matrix[rowLen-i-1][rowLen-j-1];
				matrix[rowLen-i-1][rowLen-j-1] = matrix[j][rowLen-i-1];
				matrix[j][rowLen-i-1] = temp;
			}
		}
    }
}