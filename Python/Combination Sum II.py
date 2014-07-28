
# Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

# Each number in C may only be used once in the combination.

# Note:
# All numbers (including target) will be positive integers.
# Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
# The solution set must not contain duplicate combinations.
# For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
# A solution set is: 
# [1, 7] 
# [1, 2, 5] 
# [2, 6] 
# [1, 1, 6] 

class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
	def combinationSum2(self, candidates, target):
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
			result.append(list(solution))
			return
		for i in range(level,len(candidates)):
			if i > level and candidates[i] == candidates[i-1]:
					continue
			Sum = Sum + candidates[i]
			solution.append(candidates[i])
			self.getCombinations(candidates,Sum,i+1,target,solution,result)
			solution.pop()
			Sum = Sum - candidates[i]
			
aa = [34,34,29,29,31,30,7,22,13,28,33,13,6,14,31,25,17,7,6,9,12,7,7,11,6,33,24,8,18,26,5,9,17,29,33,13,24,28,22,25,21,20,25,23,29,22,13,11,24,6,7,23,30,10,21,32,8,10,27,13,23,19,17,5]
target = 21
s = Solution()
print s.combinationSum2(aa,target)