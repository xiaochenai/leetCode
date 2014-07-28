class Solution:
    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
	def exist(self, board, word):
		self.totalRow, self.totalCol = len(board), len(board[0])
		for i in range(0,self.totalRow):
			for j in range(0,totalCol):
				if board[i][j] == word[0]:
					if self.dfs(board,i,j,word[1:]): return True
		return False
	def dfs(self,board,r,c,word):
		if len(word) == 0:return True
		if r>0 and board[r-1][c] == word[0]:
			ch, board[r][c] = board[r][c], "#"
			if self.dfs(board,r-1,c,word[1:]):return True
			board[r][c] = ch
		if r < self.totalRow-1 and board[r+1][c] == word[0]:
			ch, board[r][c] = board[r][c],"#"
			if self.dfs(board,r+1,c,word[1:]):return True
			board[r][c]=ch
		if c>0 and board[r][c-1] == word[0]:
			ch,board[r][c]=board[r][c],"#"
			if self.dfs(board,r,c-1,word[1:]):return True
			board[r][c] = ch
		if c < self.totalCol-1 and board[r][c+1] == word[0]:
			ch,board[r][c]=board[r][c],"#"
			if self.dfs(board,r,c+1,word[1:]):return True
			board[r][c] = ch
		return False