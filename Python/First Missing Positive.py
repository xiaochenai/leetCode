# Given an unsorted integer array, find the first missing positive integer.

# For example,
# Given [1,2,0] return 3,
# and [3,4,-1,1] return 2.

# Your algorithm should run in O(n) time and uses constant space.


class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
		leng = len(A)
		for i in range(0,leng):
			while A[i] != i+1:
				if A[i] <=0 or A[i] > leng or A[i] == A[A[i] - 1]:
					break
				temp = A[i]
				A[i] = A[temp-1]
				A[temp-1] = temp
		for i in range(0,leng):
			if A[i] != i+1:
				return i+1
		return leng+1
		
		
class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        length = len(A)
        for i in xrange(length):
            while A[i] != i + 1:
                if A[i] <= 0 or A[i] > length or A[i] == A[A[i]-1]: break
                # swap A[i], A[A[i]-1]
                t = A[A[i]-1]; A[A[i]-1] = A[i]; A[i] = t
        for i in xrange(length):
            if A[i] != i + 1:
                return i + 1
        return length + 1