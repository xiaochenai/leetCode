class Unique Paths II{
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0)
        	return 0;
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[][] path = new int[rowLen][colLen];
        if(obstacleGrid[0][0] == 1)
        	return 0;
        else
        	path[0][0] = 1;
        for(int i=1;i<colLen;i++){
        	if(obstacleGrid[0][i] == 1)
        		path[0][i] = 0;
        	else
        		path[0][i] = path[0][i-1];
        }
        for(int i=1;i<rowLen;i++){
        	if(obstacleGrid[i][0] == 1)
        		path[i][0] = 0;
        	else
        		path[i][0] = path[i-1][0];
        }
        for(int i=1;i<rowLen;i++){
        	for(int j=1;j<colLen;j++){
	        	if(obstacleGrid[i][j] == 1)
	        		path[i][j] = 0;
	        	else
	        		path[i][j] = path[i-1][j]+path[i][j-1];
	        	}
        }
        return path[rowLen-1][colLen-1];
    }
}