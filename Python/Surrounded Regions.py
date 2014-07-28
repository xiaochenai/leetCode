class Solution:
    # @param board, a 2D array
    # Capture all regions by modifying the input board in-place.
    # Do not return any value.
	#search from the boundaries, find all neighbour O , these Os can not be surrounded, the search method(BFS or DFS) doesnt matter. 
    def solve(self, board):
		if board==[]:return[]
		colNum = len(board[0])
		lineNum = len(board)
		queue = collections.deque()
		visited = [[False for j in xrange(colNum)] for i in xrange(lineNum)]
		for i in xrange(colNum):
			if board[0][i] == "O":queue.append((0,i))
			if board[lineNum-1][i]=="O":queue.append((lineNum-1,i))
		for i in xrange(lineNum):
			if board[i][0] == "O":queue.append((i,0))
			if board[i][colNum-1] == "O":queue.append((i,colNum-1))
		while queue:
			t = queue.popleft()
			if board[t[0]][t[1]] == "O":board[t[0]][t[1]]="$"
			visited[t[0]][t[1]]=True
			if t[0]+1 < lineNum and board[t[0]+1][t[1]] == "O" and visited[t[0]+1][t[1]]==False:
				queue.append((t[0]+1,t[1]))
			if t[0]-1 > 0 and board[t[0]-1][t[1]] == "O" and visited[t[0]-1][t[1]]==False:
				queue.append((t[0]-1,t[1]))
			if t[1] + 1 < colNum and board[t[0]][t[1] + 1] == 'O' and visited[t[0]][t[1] + 1] == False: 
				queue.append((t[0], t[1] + 1))
			if t[1] - 1 >= 0 and board[t[0]][t[1] - 1] == 'O' and visited[t[0]][t[1] - 1] == False:
				queue.append((t[0], t[1] - 1))
		for i in xrange(lineNum):
			for j in xrange(colNum):
				if board[i][j] == 'O': board[i][j] = 'X'
				if board[i][j] == '$': board[i][j] = 'O'