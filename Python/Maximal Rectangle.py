# Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

class Solution:
    # @param matrix, a list of lists of 1 length string
    # @return an integer
    def maximalRectangle(self, matrix):
		row = len(matrix)
		if row == 0:
			return 0
		res = 0
		col = len(matrix[0])
		ones = [[0 for i in xrange(col)] for j in xrange(row)]
		for i in xrange(row):
			for j in xrange(col):
				if matrix[i][j] != "0":
					if j == 0:
						ones[i][j] = 1
					else:
						ones[i][j] = ones[i][j-1] + 1
		for i in xrange(row):
			for j in xrange(col):
				if ones[i][j] != 0:
					h = i - 1
					temp = ones[i][j]
					mini = ones[i][j]
					while h >= 0:
						if ones[h][j] == 0:
							break
						else:
							if ones[h][j] < mini:
								mini = ones[h][j]
							if temp < mini*(i-h+1):
								temp = mini*(i-h+1)
							h = h - 1
					if res < temp:
						res = temp
		return res	