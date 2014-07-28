# Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

# Below is one possible representation of s1 = "great":

    # great
   # /    \
  # gr    eat
 # / \    /  \
# g   r  e   at
           # / \
          # a   t
# To scramble the string, we may choose any non-leaf node and swap its two children.

# For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    # rgeat
   # /    \
  # rg    eat
 # / \    /  \
# r   g  e   at
           # / \
          # a   t
# We say that "rgeat" is a scrambled string of "great".

# Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    # rgtae
   # /    \
  # rg    tae
 # / \    /  \
# r   g  ta  e
       # / \
      # t   a
# We say that "rgtae" is a scrambled string of "great".

# Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.











class Solution:
    # @return a boolean
    def isScramble(self, s1, s2):
		if len(s1) != len(s2):
			return False
		A = [0 for i in xrange(26)]
		for ele in s1:
			index = ord(ele)-97
			A[index] = A[index] + 1
		for ele in s2:
			index = ord(ele)-97
			A[index] = A[index] - 1
		for ele in A:
			if ele != 0:
				return False
		if len(s1) == 1 and len(s2) == 1:
			return True
		lenS1 = len(s1)
		for i in range(1,lenS1):
			result = self.isScramble(s1[0:i],s2[0:i]) & self.isScramble(s1[i:lenS1],s2[i:lenS1])
			result = result | (self.isScramble(s1[0:i],s2[lenS1-i:lenS1]) & self.isScramble(s1[i:lenS1],s2[0:lenS1-i]))
			if result == True:
				return True
		return False
		