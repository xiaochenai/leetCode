# Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.


class Solution:
    # @param matrix, a list of lists of integers
    # RETURN NOTHING, MODIFY matrix IN PLACE.
    def setZeroes(self, matrix):
		if matrix == None:
			return
		row = len(matrix)
		col = len(matrix[0])
		zeroRow = False
		zeroCol = False
		for i in range(0,row):
			if matrix[i][0] == 0:
				zeroCol = True
		for i in range(0,col):
			if matrix[0][i] == 0:
				zeroRow = True
		for i in range(1,row):
			for j in range(1,col):
				if matrix[i][j] == 0:
					matrix[0][j] = 0
					matrix[i][0] = 0
		for i in range(1,row):
			for j in range(1,col):
				if matrix[i][0] == 0 or matrix[0][j] == 0:
					matrix[i][j] = 0
		if zeroRow is True:
			for i in range(0,col):
				matrix[0][i] = 0
		if zeroCol is True:
			for i in range(0,row):
				matrix[i][0] = 0