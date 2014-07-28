# Follow up for "Search in Rotated Sorted Array":
# What if duplicates are allowed?

# Would this affect the run-time complexity? How and why?

# Write a function to determine if a given target is in the array


class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return an integer
    def search(self, A, target):
		if len(A) == 0:
			return -1
		if target >= A[0]:
			for ele in A:
				if ele == target:
					return True
				if ele < A[0]:
					return False
		else:
			lastIndex = len(A) - 1
			for i in range(lastIndex,-1,-1):
				if A[i] > A[lastIndex]:
					return False
				if A[i] == target:
					return True
		return False
        