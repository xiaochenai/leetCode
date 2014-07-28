class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
		table = [[0 for i in xrange(n)] for j in xrange(m)]
		table[0][1] = 1
		table[1][0] = 1
		for i in range(1,m):
			for j in range(1,n):
				table[i][j] = table[i-1][j] + table[i][j-1]
		return table[m-1][n-1]
		
#solution 2

class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
		table = [1 for i in xrange(n)]
		for i in range(1,m):
			for j in range(1,n):
				table[j] = table[j] + table[j-1]
		return table[n-1]
		
#solution 3
class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
		if m==1 or n == 1:
			return 1
		return self.uniquePaths(m-1,n) + self.uniquePaths(m,n-1)