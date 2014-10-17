class Valid SudokuP{
	public boolean isValidSudoku(char[][] board) {
        //check row and col
		if (board.length == 0)
            return false;
        for(int i=0;i<board.length;i++){
        	int[] row = new int[9];
        	int[] col = new int[9];
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j] != '.'){
        			int rowIndex = board[i][j] - '1';
        			if(row[rowIndex] == 0)
        				row[rowIndex] = 1;
        			else
        				return false;
        		}
        		if(board[j][i] != '.'){
        			int colIndex = board[j][i] - '1';
        			if(col[colIndex] == 0)
        				col[colIndex] = 1;
        			else
        				return false;
        		}
        	}
        	
        }
        //check 3*3 board
        for(int i=0;i<board.length;i+=3){
        		for(int j=0;j<board[0].length;j+=3){
        			int[] block = new int[9];
        			for(int t=0;t<3;t++){
        				for(int k=0;k<3;k++){
        					if(board[i+t][j+k] != '.'){
        						int index = (board[i+t][j+k]-'1');
        						if(block[index] == 0)
        							block[index] = 1;
        						else
        							return false;
        					}
        				}
        			}
        		}
        	}
        	return true;
    }
}