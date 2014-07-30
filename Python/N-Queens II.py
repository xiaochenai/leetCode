class Solution:
    # @return an integer
    def totalNQueens(self, n):
        self.res = 0
        self.solve(n, 0, [-1 for i in xrange(n)])
        return self.res
     
    def solve(self, n, currQueenNum, board):
        if currQueenNum == n: self.res += 1; return
        # try to put a Queen in (currQueenNum, 0), (currQueenNum, 1), ..., (currQueenNum, n-1)
        for i in xrange(n):
            valid = True  # test whether board[currQueenNum] can be i or not
            for k in xrange(currQueenNum):
                # check column
                if board[k] == i: valid = False; break
                # check diagonal
                if abs(board[k] - i) == currQueenNum - k: valid = False; break
            if valid:
                board[currQueenNum] = i
                self.solve(n, currQueenNum + 1, board)
				
#N Quene Problem
#类似于DFS，用递归解决。按行放置，当前行放完以后查看下一行可以放置的地方，然后再是下下行，以此类推。