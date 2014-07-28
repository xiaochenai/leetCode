class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
		if s=="" or s[0]=="0":return 0
		dp=[1,1]
		for i in range(2,len(s)+1):
			if 10<=int(s[i-2:i])<=26 and 0<int(s[i-1])<10:
				dp.append(dp[i-2]+dp[i-1])
			elif 10<=int(s[i-2:i])<=26:
				dp.append(dp[i-2])
			elif 0<int(s[i-1])<10:
				dp.append(dp[i-1])
			else:
				return 0
		return dp[len(s)]