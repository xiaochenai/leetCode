# Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

# Integers in each row are sorted from left to right.
# The first integer of each row is greater than the last integer of the previous row.
# For example,

# Consider the following matrix:

# [
  # [1,   3,  5,  7],
  # [10, 11, 16, 20],
  # [23, 30, 34, 50]
# ]
# Given target = 3, return true.


class Solution:
    # @param matrix, a list of lists of integers
    # @param target, an integer
    # @return a boolean
    def searchMatrix(self, matrix, target):
		if len(matrix) == 0:
			return False
		if len(matrix[0]) == 0:
			return False
		y = len(matrix)
		x = len(matrix[0])
		current = 0
		for i in range(0,y):
			if target >= matrix[i][0] and target <= matrix[i][x-1]:
				current = i
				break
		return (target in matrix[current])