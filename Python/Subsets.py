# Given a set of distinct integers, S, return all possible subsets.

# Note:
# Elements in a subset must be in non-descending order.
# The solution set must not contain duplicate subsets.
# For example,
# If S = [1,2,3], a solution is:

# [
  # [3],
  # [1],
  # [2],
  # [1,2,3],
  # [1,3],
  # [2,3],
  # [1,2],
  # []
# ]


class Solution:
    # @param S, a list of integer
    # @return a list of lists of integer
	def subsets(self, S):
		result = []
		output = []
		if len(S) == 0:
			return result
		result.append(output)
		S.sort()
		self.generateSub(S,0,result,output)
		return result
	def generateSub(self,S,step,result,output):
		for i in range(step,len(S)):
			output.append(S[i])
			result.append(list(output))
			if i < (len(S) - 1):
				self.generateSub(S,i+1,result,output)
			output.pop()