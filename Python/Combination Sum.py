# Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

# The same repeated number may be chosen from C unlimited number of times.

# Note:
# All numbers (including target) will be positive integers.
# Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
# The solution set must not contain duplicate combinations.
# For example, given candidate set 2,3,6,7 and target 7, 
# A solution set is: 
# [7] 
# [2, 2, 3] 


class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
	def combinationSum(self, candidates, target):
		result = []
		solution = []
		Sum = 0
		candidates.sort()
		self.getCombinations(candidates,Sum,0,target,solution,result)
		return result
	def getCombinations(self,candidates,Sum,level,target,solution,result):
		if Sum > target:
			return
		if Sum == target:
			temp = list(solution)
			if temp not in result:
				result.append(temp)
			return
		for i in range(level,len(candidates)):
			Sum = Sum + candidates[i]
			solution.append(candidates[i])
			self.getCombinations(candidates,Sum,i,target,solution,result)
			solution.pop()
			Sum = Sum - candidates[i]

s = Solution()
a= [1,1]
b = 2
print s.combinationSum(a,b)