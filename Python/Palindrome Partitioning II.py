class Solution:
    # @param s, a string
    # @return an integer
    def minCut(self, s):
		Len = len(s)
		isPal = [[False for j in xrange(Len)] for i in xrange(Len)]
		minPalNum = [i+1 for i in range(Len)]
		for j in xrange(Len):
			for i in xrange(j+1):
				if s[i] == s[j] and (j-i <=1 or isPal[i+1][j-1] == True):
					isPal[i][j] = True
					minPalNum[j] = min(minPalNum[j],minPal[i-1]+1) if i>0 else min(minPalNum[j],1)
		return minPalNum[Len-1]-1