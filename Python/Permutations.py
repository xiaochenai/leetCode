# Given a collection of numbers, return all possible permutations.

# For example,
# [1,2,3] have the following permutations:
# [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
	def permute(self, num):
		result = []
		visited = [0 for i in range(0,len(num))]
		solution=[]
		step = 0
		if len(num) == 0:
			return []
		self.findpermute(visited,solution,result,num,step)
		return result
	def findpermute(self,visited,solution,result,num,step):
		if step == len(num):
			result.append(list(solution))
			return
		for i in range(0,len(num)):
			if visited[i] == 0:
				visited[i] = 1
				solution.append(num[i])
				self.findpermute(visited,solution,result,num,step+1)
				solution.pop()
				visited[i]=0