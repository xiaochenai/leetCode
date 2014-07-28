# Follow up for "Remove Duplicates":
# What if duplicates are allowed at most twice?

# For example,
# Given sorted array A = [1,1,1,2,2,3],

# Your function should return length = 5, and A is now [1,1,2,2,3]


class Solution:
    # @param A a list of integers
    # @return an integer
    def removeDuplicates(self, A):
		i = 1
		leng = len(A)
		if leng == 0:
		       return 0
		current = A[0]
		currentIndex = 0
		currentCount = 0
		while i < len(A):
			if current == A[i]:
				if currentCount == 0:
					currentCount = 1
					current = A[i]
					A[currentIndex + 1] = A[i]
					currentIndex = currentIndex + 1
					i = i + 1
				else:
					leng = leng - 1
					i = i + 1	
			else:
				currentCount = 0
				current = A[i]
				A[currentIndex + 1] = A[i]
				currentIndex = currentIndex + 1
				i = i + 1
		A = A[0:leng]
		return leng
		