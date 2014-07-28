# Given a string s, partition s such that every substring of the partition is a palindrome.

# Return all possible palindrome partitioning of s.

# For example, given s = "aab",
# Return

  # [
    # ["aa","b"],
    # ["a","a","b"]
  # ]
  
  

class Solution:
    # @param s, a string
    # @return a list of lists of string
	def partition(self, s):
		result = []
		output = []
		self.DFS(s,0,output,result)
		return result
	def DFS(self,S,start,output,result):
		if start == len(S):
			result.append(list(output))
			return
		for i in range(start,len(S)):
			if self.isPalindrome(S,start,i):
				output.append(S[start:(i+1)])
				self.DFS(S,i+1,output,result)
				output.pop()
	def isPalindrome(self,S,start,end):
		while start < end:
			if S[start] != S[end]:
				return False
			start = start + 1
			end = end - 1
		return True