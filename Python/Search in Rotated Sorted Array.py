# Suppose a sorted array is rotated at some pivot unknown to you beforehand.

# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

# You are given a target value to search. If found in the array return its index, otherwise return -1.

# You may assume no duplicate exists in the array.


class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return an integer
    def search(self, A, target):
		if target in A:
			return A.index(target)
		else:
			return -1
			
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
					return A.index(ele)
				if ele < A[0]:
					return -1
		else:
			lastIndex = len(A) - 1
			for i in range(lastIndex,-1,-1):
				if A[i] > A[lastIndex]:
					return -1
				if A[i] == target:
					return i
		return -1