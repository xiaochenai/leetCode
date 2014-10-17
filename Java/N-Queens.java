class N-Queens{
	private ArrayList<String[]> res = new ArrayList<String[]>();
	public ArrayList<String[]> solveNQueens(int n) {
        int[] colForRow = new int[n];
        placeQueen(n,0,colForRow);
        return res;
    }
    private void placeQueen(int n, int row, int[] colForRow){
    	if(row == n){
    		genBoard(colForRow);
    		return;
    	}
    	for(int i=1;i<=n;i++){
    		colForRow[row] = i;
    		if(isValid(colForRow,row))
    			placeQueen(n,row+1,colForRow);

    	}
    }
    private boolean isValid(int[] colForRow, int row){
    	for(int i=0;i<row;i++){
    		if(colForRow[i] == colForRow[row] || Math.abs(colForRow[i]-colForRow[row]) == row-i){
    			return false;
    		}
    	}
    	return true;
    }
    private void genBoard(int[] colForRow){
    	String[] board = new String[n];
    	for(int i=0;i<n;i++){
    		String s = "";
    		for(int j=0;j<n;j++){
    			if(colForRow[i] == (j+1))
    				s = s + "Q";
    			else
    				s= s + '.';
    		}
    		board[i] = s;
    	}
    	res.add(board);
    }
}