class Solution:
    # @param s, a string
    # @return a list of strings
	def restoreIpAddresses(self, s):
		res = []
		if len(s) < 4 or len(s) > 12:
			return res
		self.dfs(s,"",res,0)
		return res
	def dfs(self,s,temp,res,count):
		if count==3 and self.isValidIP(s):
			res.append(temp+s)
			return
		i = 1
		while i<4 and i<len(s):
			substr = s[0:i]
			if self.isValidIP(substr):
				self.dfs(s[i:],temp+substr+".",res,count+1)
			i = i + 1
	def isValidIP(self,s):
		if s[0]=="0":
			return s=="0"
		else:
			return int(s)>0 and int(s)<=255