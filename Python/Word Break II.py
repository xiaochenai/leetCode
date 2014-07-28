class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
	def wordBreak(self, s, dict):
		Solution.res = []
		self.dfs(s,dict,"")
		return Solution.res
	def dfs(self,s,dict,stringList):
		if self.check(s,dict):
			if len(s) == 0:Solution.res.append(stringList[1:])
			for i in range(1,len(s)+1):
				if s[:i] in dict:
					self.dfs(s[i:],dict,stringList+" "+s[:i])
	def check(self,s,dict):
		dp = [False for i in range(len(s)+1)]
		dp[0] = True
		for i in range(1,len(s)+1):
			for j in range(0,i):
				dp[i] = (dp[j] and s[j:i] in dict)
				if dp[i]:break
		return dp[len(s)]