class Surrounded Regions{
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int rowLen = board.length;
        int colLen = board.length;
        boolean[] visited = new boolean[rowLen][colLen];
        LinkedList<Integer> rowQ = new LinkedList<Integer>();
        LinkedList<Integer> colQ = new LinkedList<Integer>();
        for(int i=0;i<rowLen;i++){
        	if(board[i][0] == 'O'){
        		rowQ.offer(i);
        		colQ.offer(0);
        	}
        	if(board[i][colLen-1] == 'O'){
        		rowQ.offer(i);
        		colQ.offer(colLen-1);
        	}
        }
        for(int i=0;i<colLen;i++){
        	if(board[0][i] == 'O'){
        		rowQ.offer(0);
        		colQ.offer(i);
        	}
        	if(board[rowLen-1][i] == 'O'){
        		rowQ.offer(rowLen-1);
        		colQ.offer(i);
        	}
        }
        while(!rowQ.isEmpty()){
        	int x = rowQ.poll();
        	int y = colQ.poll();
        	if(board[x][y] == 'O')
        		board[x][y] = '$';
        	visited[x][y] = true;
        	if(x+1 < rowLen && visited[x+1][y] == false && board[x+1][y] == 'O'){
        		rowQ.offer(x+1);
        		colQ.offer(y);
        	}
        	if(x-1 > 0 && visited[x-1][y] == false && board[x-1][y] == 'O'){
        		rowQ.offer(x-1);
        		colQ.offer(y);
        	}
        	if(y+1 < colLen && visited[x][y+1] == false && board[x][y+1] == 'O'){
        		rowQ.offer(x);
        		colQ.offer(y+1);
        	}
        	if(y-1 > 0 && visited[x][y-1] == false && board[x][y-1] == 'O'){
        		rowQ.offer(x);
        		colQ.offer(y-1);
        	}
        }
        for(int i=0;i<rowLen;i++){
        	for(int j=0;j<colLen;j++){
        		if(board[i][j] == 'O')
        			board[i][j] = 'X';
        		if(board[i][j] == '$')
        			board[i][j] = 'O';
        	}
        }
    }	
}