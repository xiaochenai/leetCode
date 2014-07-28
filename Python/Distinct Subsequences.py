# Given a string S and a string T, count the number of distinct subsequences of T in S.

# A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

# Here is an example:
# S = "rabbbit", T = "rabbit"

# Return 3.


class Solution:
    # @return an integer
    def numDistinct(self, S, T):
		match = [0 for i in xrange(len(T)+1)]
		if len(S) < len(T):
			return 0
		match[0] = 1
		for i in range(1,len(S)+1):
			for j in range(len(T),0,-1):
				if S[i-1] == T[j-1]:
					match[j] = match[j] + match[j-1]
		return match[len(T)]