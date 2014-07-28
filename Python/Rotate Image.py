# You are given an n x n 2D matrix representing an image.

# Rotate the image by 90 degrees (clockwise).

# Follow up:
# Could you do this in-place?

class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of lists of integers
    def rotate(self, matrix):
		n = len(matrix)
		new = [[0 for i in xrange(n)] for j in xrange(n)]
		for i in range(0,n):
			for j in range(0,n):
				new[j][n-i-1] = matrix[i][j]
		return new