# Given a collection of numbers that might contain duplicates, return all possible unique permutations.

# For example,
# [1,1,2] have the following unique permutations:
# [1,1,2], [1,2,1], and [2,1,1].


class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
	def permuteUnique(self, num):
		result = []
		visited = [0 for i in range(0,len(num))]
		solution=[]
		step = 0
		num.sort()
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
				if i > 0 and num[i] == num[i-1] and visited[i-1] == 0:
					continue
				visited[i] = 1
				solution.append(num[i])
				self.findpermute(visited,solution,result,num,step+1)
				solution.pop()
				visited[i]=0