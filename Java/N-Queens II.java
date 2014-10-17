class N-Queens II{
	private int total = 0;
	public int totalNQueens(int n) {
        int[] colForRow = new int[n];
        if(n <= 0)
        	return 0;
        placeQueen(n,colForRow,0);
        return this.total;
    }
    private void placeQueen(int n, int[] colForRow, int row){
    	if(row == n){
    		total++;
    		return;
    	}
    	for(int i=1;i<=n;i++){
    		colForRow[row] = i;
    		if(isValid(row, colForRow)){
    			placeQueen(n,colForRow,row+1);
    		}
    		colForRow[row] = 0;
    	}
    }
    private boolean isValid(int row, int[] colForRow){
    	for(int i=0;i<row;i++){
    		if(colForRow[i] == colForRow[row] || Math.abs(colForRow[i]-colForRow[row]) == row-i){
    			return false;
    		}
    	}
    	return true;
    }
}