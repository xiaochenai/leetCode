


class Solution:
    # @param A, a list of integers
    # @return an integer
    def trap(self, A):
		if len(A) < 2:
			return 0
		leng = len(A)
		maxL = [0 for i in xrange(len(A))]
		maxR = [0 for i in xrange(len(A))]
		Max = A[0]
		maxL[0] = 0
		for i in range(1,len(A)-1):
			maxL[i] = Max
			if Max < A[i]:Max = A[i]
		Max = A[leng - 1]
		maxR[leng-1] = 0
		currentTrap = 0
		totalTrap = 0
		for i in range(leng-2,0,-1):
			maxR[i] = Max
			currentTrap = min(maxL[i],maxR[i]) - A[i]
			if currentTrap > 0:
				totalTrap = totalTrap + currentTrap
			if Max < A[i]:
				Max = A[i]
		return totalTrap