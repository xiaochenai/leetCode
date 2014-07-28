# Given a sorted array of integers, find the starting and ending position of a given target value.

# Your algorithm's runtime complexity must be in the order of O(log n).

# If the target is not found in the array, return [-1, -1].

# For example,
# Given [5, 7, 7, 8, 8, 10] and target value 8,
# return [3, 4].


class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
		leng = len(A)
		if leng == 0:
			return [-1,-1]
		start = A[0]
		startIndex = 0
		endIndex = leng-1
		end = A[leng-1]
		while (start != end) and startIndex <=endIndex:
			if start != target and end != target:
				startIndex = startIndex + 1
				endIndex = endIndex - 1
				start = A[startIndex]
				end = A[endIndex]
				continue
			if start == target and end != target:
				endIndex = endIndex - 1
				end = A[endIndex]
			if start != target and end == target:
				startIndex = startIndex + 1
				start = A[startIndex]
		if startIndex > endIndex:
			return [-1,-1]
		if startIndex <= endIndex and start == target:
			return[startIndex,endIndex]
		if startIndex <= endIndex and start != target:
			return [-1,-1]
			