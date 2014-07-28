# Given two sorted integer arrays A and B, merge B into A as one sorted array.

# Note:
# You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
#########################
# have no idea why first one is not correct in leetcode
######################
class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
		current = 0
		for i in range(0,len(B)):
			leng = len(A)
			while leng == len(A):
				if current < len(A):
					if B[i] <= A[current]:
						A.insert(current,B[i])
						current = current + 1
					else:
						current = current + 1
				else:
					A.append(B[i])
					current = current + 1
		print A

s = Solution()
a = []
b = [1,2,3]
s.merge(a,len(a),b,len(b))

class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing
    def merge(self, A, m, B, n):
		k = m + n -1
		i = m-1
		j = n-1
		while i>=0 and j >= 0:
			if A[i] >= B[j]:
				A[k] = A[i]
				i = i - 1
			else:
				A[k] = B[j]
				j = j - 1
			k = k - 1
		while j >= 0:
			A[k] = B[j]
			k = k - 1
			j = j - 1