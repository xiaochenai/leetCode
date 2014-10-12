class N-Queens{
	//dfs
	//when a dfs is valid generate a chess board
	public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] colforRow = new int[n];
        placeQueen(res,0,colforRow,n);
        return res;

    }
    private void placeQueen(ArrayList<String[]> res, int row, int[] colforRow,int n){
    	if(row == n){
    		genBoard(res,colforRow,n);
    		return;
    	}
    	for(int i=0;i<n;i++){
    		colforRow[row] = i;
    		if(check(row,colforRow))
    			placeQueen(res,row+1,colforRow,n);
    	}
    }
    private boolean check(int row, int[] colforRow){
    	for(int i=0;i<row;i++){
    		if(colforRow[i] == colforRow[row] || (Math.abs(colforRow[i]-colforRow[row]) == row-i))
    			return false;
    	}
    	return true;
    }
    private void genBoard(ArrayList<String[]> res, int[] colforRow,int n){
    	String[] fills = new String[n];
    	for(int i=0;i<n;i++){
    		String fill = "";
    		for(int j=0;j<n;j++){
    			if(colforRow[i] == j)
    				fill = fill + "Q";
    			else
    				fill = fill + ".";
    		}
    		fills[i] = fill;
    	}
    	res.add(fills);
    }
}