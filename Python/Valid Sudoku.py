class Solution:
    # @param board, a 9x9 2D array
    # @return a boolean
    def isValidSudoku(self, board):
		if len(board) == 0:
			return False
		for i in range(0,9):
			row = [0 for j in xrange(9)]
			col = [0 for j in xrange(9)]
			for j in range(0,9):
				if board[i][j] != ".":
					if row[int(board[i][j])-10] == 1:
						return False
					row[int(board[i][j])-10] = row[int(board[i][j])-10] + 1
				if board[j][i] != ".":
					if col[int(board[j][i])-10] == 1:
						return False
					col[int(board[j][i])-10] = col[int(board[j][i])-10] + 1
		for i in range(0,9,3):
			for j in range(0,9,3):
				row = [0 for u in xrange(9)]
				for t in range(0,3):
					for k in range(0,3):
						if board[t+i][k+j] == ".":
							continue
						if row[int(board[t+i][k+j])-10] == 1:
							return False
						row[int(board[t+i][k+j])-10] = row[int(board[t+i][k+j])-10] + 1
		return True