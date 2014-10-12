class N-Queens_II{
	private int total = 0;
	public int totalNQueens(int n) {
        int[] colForRow = new int[n];
        if(n <= 0)
        	return 0;
        placeQueen(0,n,colForRow);
        return this.total;
    }
    private void placeQueen(int row,int n,int[] colForRow){
    	if(row == n){
    		this.total++;
    		return;
    	}
    	for(int i=0;i<n;i++){
    		colForRow[row] = i;
    		if(check(row,colForRow))
    			placeQueen(row+1,n,colForRow);
    	}

    }
    private boolean check(int row, int[] colForRow){
    	for(int i=0;i<row;i++){
    		if(colForRow[i] == colForRow[row] || Math.abs(colForRow[i]-colForRow[row]) == row-i)
    			return false;
    	}
    	return true;
    }
}