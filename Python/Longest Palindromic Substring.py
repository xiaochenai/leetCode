class Solution:
    # @return a string
	startIndex = 0
	Len = 0
	def longestPalindrome(self, s):
		SI = 0
		EI = 0
		for i in range(0,len(s)-1):
			if s[i] == s[i+1]:
				SI = i
				EI = i+1
				self.Search(s,SI,EI,self.Len,self.startIndex)
			SI = i
			EI = i
			self.Search(s,SI,EI,self.Len,self.startIndex)
		if self.Len==0:
			self.Len = len(s)
		return s[self.startIndex:self.startIndex+self.Len]
	def Search(self,s,SI,EI,Len,startIndex):
		step = 1
		while (SI-step)>=0 and (EI+step)<len(s):
			if s[SI-step] != s[EI+step]:
				break
			step = step + 1
		width = 2*step - 1 +EI - SI
		if width > self.Len:
			self.Len = width
			self.startIndex = SI-step+1
			
# There is a DP solution

# P[i,j] = 1  if i ==j
        # =  S[i] ==S[j]   if j = i+1
        # =  S[i] == S[j] && P[i+1][j-1]  if j>i+1
class Solution:
    # @return a string
	startIndex = 0
	Len = 0
	def longestPalindrome(self, s):
		Len = len(s)
		P = [[0 for i in range(0,Len)] for j in range(0,Len)]
		maxL = 0
		start=0
		end = 0
		for i in range(0,Len):
			for j in range(0,i):
				P[j][i] = (s[i]==s[j] & (i-j < 2 | P[j+1][i-1]))
				if P[j][i] & (maxL < (i-j+1):
					maxL = i-j+1
					start = j
					end = i
			P[i][i] = 1
		return s[start:send]