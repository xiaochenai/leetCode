class Sudoku Solver{
	public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    private boolean solve(char[][] board, int row, int col){
    	int nextRow = 0;
    	int nextCol = 0;
    	if(row == 9)
    		return true;
    	if(col == 9){
    		nextRow = row + 1;
    		nextCol = 0;
    	}
    	else{
    		nextCol = col+1;
    		nextRow = row;
    	}
    	if(board[i][j] != '.')
    		return (solve(board,nextRow,nextCol));
    	else{
    		for(char i='1';i<='9';i++){
    			board[row][col] = i;
    			if(isValid(board,row,col)){
    				if(solve(board,nextRow,nextCol))
    				return true;
    			}
    			board[row][col] = '.';
    		}
    	}
    	return false;
    }
    private boolean isValid(char[][] board, int i, int j){
    	for(int col=0;col<9;col++){
            if(board[i][col] == board[i][j] && col != j)
                return false;
        }
        for(int row=0;row<9;row++){
            if(board[row][j] == board[i][j] && row != i)
                return false;
        }
        for(int row=i/3*3;row<i/3*3+3;row++){
            for(int col=j/3*3;col<j/3*3+3;col++){
                if(board[row][col] == board[i][j] && row !=i && col != j)
                    return false;
            }
        }
        return true;
    }
}