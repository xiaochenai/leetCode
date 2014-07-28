# Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

# Do not allocate extra space for another array, you must do this in place with constant memory.

# For example,
# Given input array A = [1,1,2],

# Your function should return length = 2, and A is now [1,2].

class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
		i = 1
		leng = len(A)
		if leng == 0:
		       return 0
		current = A[0]
		currentIndex = 0
		while i < len(A):
			if current == A[i]:
				leng = leng - 1
				i = i + 1
				
			else:
				current = A[i]
				A[currentIndex + 1] = A[i]
				currentIndex = currentIndex + 1
				i = i + 1
		A = A[0:leng]
		return leng
s = Solution()
a = [1,1,2,3]
print s.removeDuplicates(a)
