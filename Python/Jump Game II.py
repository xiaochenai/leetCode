# Given an array of non-negative integers, you are initially positioned at the first index of the array.

# Each element in the array represents your maximum jump length at that position.

# Your goal is to reach the last index in the minimum number of jumps.

# For example:
# Given array A = [2,3,1,1,4]

# The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)\


class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
		start = 0
		end = 0
		count = 0
		n = len(A)
		if n == 1:
			return 0
		while end < n:
			Max = 0
			count = count + 1
			for i in range(start,end+1):
				if A[i] + i >= n-1:
					return count
				if A[i] + i >= Max:
					Max = A[i] + i
			start = end + 1
			end = Max