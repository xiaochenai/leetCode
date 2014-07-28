# Follow up for "Unique Paths":

# Now consider if some obstacles are added to the grids. How many unique paths would there be?

# An obstacle and empty space is marked as 1 and 0 respectively in the grid.

# For example,
# There is one obstacle in the middle of a 3x3 grid as illustrated below.

# [
  # [0,0,0],
  # [0,1,0],
  # [0,0,0]
# ]
# The total number of unique paths is 2.

# Note: m and n will be at most 100


class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
		m = len(obstacleGrid)
		if m == 0:
			return 0
		n = len(obstacleGrid[0])
		table = [[0 for i in xrange(n)] for j in xrange(m)]
		if obstacleGrid[0][0] == 1:
		        return 0
		table[0][0] = 1
		for i in range(0,m):
			for j in range(0,n):
				if obstacleGrid[i][j] != 1:
					if not (i==0 and j==0):
						if i==0:
							table[i][j] = table[i][j-1]
						if j==0:
							table[i][j] = table[i-1][j]
						if i!=0 and j!=0:
							table[i][j] = table[i-1][j] + table[i][j-1]
				else:
					table[i][j] = 0
		return table[m-1][n-1]
#########
class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
		m = len(obstacleGrid)
		if m == 0:
			return 0
		n = len(obstacleGrid[0])
		if obstacleGrid[0][0] == 1:
			return 0
		maxV = [0 for i in xrange(n)]
		maxV[0] = 1
		for i in range(0,m):
			for j in range(0,n):
				if obstacleGrid[i][j] == 1:#already dealed with the situation that ob[i][0] is 1
					maxV[j] = 0
				elif j>0:
					maxV[j] = maxV[j] + maxV[j-1]
		return maxV[n-1]