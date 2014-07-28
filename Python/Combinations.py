# Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

# For example,
# If n = 4 and k = 2, a solution is:

# [
  # [2,4],
  # [3,4],
  # [2,3],
  # [1,2],
  # [1,3],
  # [1,4],
# ]


class Solution:
    # @return a list of lists of integers
	def combine(self, n, k):
		result = []
		solution = []
		self.getCombine(n,k,1,solution,result)
		return result
	def getCombine(self,n,k,level,solution,result):
		if len(solution) == k:
			result.append(list(solution))
			return
		for i in range(level,n+1):
			solution.append(i)
			self.getCombine(n,k,i+1,solution,result)
			solution.pop()