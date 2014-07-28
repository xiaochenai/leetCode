# Given a collection of integers that might contain duplicates, S, return all possible subsets.

# Note:
# Elements in a subset must be in non-descending order.
# The solution set must not contain duplicate subsets.
# For example,
# If S = [1,2,2], a solution is:

# [
  # [2],
  # [1],
  # [1,2,2],
  # [2,2],
  # [1,2],
  # []
# ]


class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
	def subsetsWithDup(self, S):
		result = []
		output = []
		if len(S) == 0:
			return result
		result.append(list(output))
		S.sort()
		self.generateSub(S,0,result,output)
		return result
	def generateSub(self,S,step,result,output):
		for i in range(step,len(S)):
			output.append(S[i])
			temp = list(output)
			if temp not in result:
				result.append(temp)
			if i < (len(S) - 1):
				self.generateSub(S,i+1,result,output)
			output.pop()
#
class Solution:
    # @param S, a list of integer
    # @return a list of lists of integer
	def subsetsWithDup(self, S):
		result = []
		output = []
		if len(S) == 0:
			return result
		result.append(list(output))
		S.sort()
		self.generateSub(S,0,result,output)
		return result
	def generateSub(self,S,step,result,output):
		i = step
		while i < len(S):
			output.append(S[i])
			result.append(list(output))
			if i < (len(S) - 1):
				self.generateSub(S,i+1,result,output)
			output.pop()
			while (i<len(S)-1) and S[i]==S[i+1]:
				i = i + 1
			i = i + 1