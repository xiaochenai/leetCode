class Word Search{
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0 || word == null)
			return false;
		int rowLen = board.length;
		int colLen = board[0].length;
		for(int i=0;i<rowLen;i++){
			for(int j=0;j<colLen;j++){
				if(word.charAt(0) == board[i][j]){
					if(dfs(board,i,j,word.substring(1)))
						return true;
				}
			}
		}
		return false;
	}
	private boolean dfs(char[][] board, int row, int col, String s){
		if(s.length() == 0)
			return true;
		if(row > 0 && board[row-1][col] == s.charAt(0)){
			char c = board[row][col];
			board[row][col] = '$';
			if(dfs(board,row-1,col,s.substring(1)))
				return true;
			board[row][col] = c;
		}
		if(row<board.length-1 && board[row+1][col] == s.charAt(0)){
			char c = board[row][col];
			board[row][col] = '$';
			if(dfs(board,row+1,col,s.substring(1)))
				return true;
			board[row][col] = c;
		}
		if(col > 0 && board[row][col-1] == s.charAt(0)){
			char c = board[row][col];
			board[row][col] = '$';
			if(dfs(board,row,col-1,s.substring(1)))
				return true;
			board[row][col] = c;
		}
		if(col < board[0].length-1 && board[row][col+1] == s.charAt(0)){
			char c = board[row][col];
			board[row][col] = '$';
			if(dfs(board,row,col+1,s.substring(1)))
				return true;
			board[row][col] = c;
		}
		return false;
	}
}