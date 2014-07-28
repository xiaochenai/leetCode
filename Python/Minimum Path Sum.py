# Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

# Note: You can only move either down or right at any point in time.

class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
		if len(grid) == 0:
			return 0
		m = len(grid)
		n = len(grid[0])
		MinV = [[0 for i in xrange(n)] for j in xrange(m)]
		MinV[0][0] = grid[0][0]
		for i in range(1,m):
			MinV[i][0] = MinV[i-1][0] + grid[i][0]
		for i in range(1,n):
			MinV[0][i] = MinV[0][i-1] + grid[0][i]
		for i in range(1,m):
			for j in range(1,n):
				MinV[i][j] = min(MinV[i-1][j],MinV[i][j-1]) + grid[i][j]
		return MinV[m-1][n-1]