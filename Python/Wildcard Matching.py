class Solution:
    # @param s, an input string
    # @param p, a pattern string
    # @return a boolean
    def isMatch(self, s, p):#main idea is match as less as possible characters for *
		pP=0
		sP=0
		ss=0
		start=-1
		while sP<len(s):
			if pP<len(p) and (s[sP]==p[pP] or p[pP]=="?"):
				sP=sP+1
				pP=pP+1
				continue
			if pP<len(p) and p[pP]=="*":
				start=pP
				pP+=1
				ss=sP
				continue
			if start!=-1:#if sP and pP does not match, find previous * and re-scan from next position of *
				pP=start+1
				ss+=1
				sP=ss
				continue
			return False
		while pP<len(p) and p[pP]=="*":
			pP=pP+1
		if pP==len(p):return True
		return False
s = Solution()
s.isMatch("aa","a*")