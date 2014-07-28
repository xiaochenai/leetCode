# Given an array of non-negative integers, you are initially positioned at the first index of the array.

# Each element in the array represents your maximum jump length at that position.

# Determine if you are able to reach the last index.

# For example:
# A = [2,3,1,1,4], return true.

# A = [3,2,1,0,4], return false.


# class Solution:
    # # @param A, a list of integers
    # # @return a boolean
    # def canJump(self, A):
		# LastIndex = len(A)-1
		# visited = [0 for i in xrange(LastIndex+1)]
		# for i in range(0,LastIndex+1):
			# currentSum = i
			# while visited[currentSum] != 1:
				# visited[currentSum] = 1
				# currentSum = currentSum + A[currentSum]
				# if currentSum > LastIndex:
					# break
				# if currentSum == LastIndex:
					# return True
		# return False
class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
		jump = [0 for i in xrange(len(A))]
		jump[0] = 0
		for i in range(1,len(A)):
			jump[i] = max(jump[i-1],A[i-1]) - 1
			if jump[i] < 0:
				return False
		return (jump[n-1]>0)
class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
		init = 0
		Max = 0
		while init < len(A) and init <= Max:
			if A[init] + init  > Max:
				Max = A[init] + init
			if Max > (len(A) - 1):
				return True
			init = init + 1
		return False