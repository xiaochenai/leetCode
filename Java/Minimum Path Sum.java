class Minimum Path Sum{
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
        	return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] min = new int[rowLen][colLen];
        min[0][0] = grid[0][0];
        for(int i=1;i<colLen;i++){
        	min[0][i] = min[0][i-1] + grid[0][i];
        }
        for(int i=1;i<rowLen;i++){
        	min[i][0] = min[i-1][0] + grid[i][0];
        }
        for(int i=1;i<rowLen;i++){
        	for(int j=1;j<colLen;j++){
        		min[i][j] = grid[i][j] + Math.min(min[i-1][j],min[i][j-1]);
        	}
        }
        return min[rowLen-1][colLen-1];
    }
}