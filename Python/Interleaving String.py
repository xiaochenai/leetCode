class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
		len1 = len(s1);len2 = len(s2);len3 = len(s3)
		if len1 + len2 != len3:
			return False
		dp = [[0 for i in xrange(len2+1)] for j in xrange(len1+1)]
		for i in xrange(len1+1):
			for j in xrange(len2+1):
				if i>0 and dp[i-1][j] == i-1+j and s1[i-1] == s3[i+j-1]:
					dp[i][j] = i+j
				if j>0 and dp[i][j-1] == i+j-1 and s2[j-1] == s3[i+j-1]:
					dp[i][j] = i+j
		return dp[len1][len2] == len3
"aa", "ab", "abaa"
class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
		len1 = len(s1);len2 = len(s2);len3 = len(s3)
		if len1 + len2 != len3:
			return False
		dp = [[0 for i in xrange(len2+1)] for j in xrange(len1+1)]
		if len2 > 0 and len3 >0:
			if s2[0] == s3[0]:
				dp[0][1]=1
		if len2>1 and len3>0 and s1[0] == s3[0]:
			dp[1][0]=1
		for i in range(1,len1+1):
			for j in range(1,len2+1):
				if dp[i-1][j] == i-1+j and s1[i-1] == s3[i+j-1]:
					dp[i][j] = i+j
				if dp[i][j-1] == i+j-1 and s2[j-1] == s3[i+j-1]:
					dp[i][j] = i+j
		return dp[len1][len2] == len3