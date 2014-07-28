# Given an index k, return the kth row of the Pascal's triangle.

# For example, given k = 3,
# Return [1,3,3,1].

# Note:
# Could you optimize your algorithm to use only O(k) extra space?


class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
		result = [0 for i in xrange(rowIndex+2)]
		result[1] = 1
		for i in range(0,rowIndex):
			for j in range(rowIndex+1,-1,-1):
				result[j] = result[j-1] + result[j]
		result.pop(0)
		return result