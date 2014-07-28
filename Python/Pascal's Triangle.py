class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        result = [[0 for x in xrange(i+1)] for i in xrange(numRows)]
		for i in range(0,numRows):
			leng = len(result[i])
			if i == 0:
				result[0][0] = 1
			else:
				for j in range(0,leng):
					if j == 0 or j == (leng-1):
						result[i][j] = 1
					else:
						result[i][j] = result[i-1][j] + result[i-1][j-1]
		return result
			