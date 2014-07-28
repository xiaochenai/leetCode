class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a boolean
    def wordBreak(self, s, dict):
		s = "#" + s
		Len = len(s)
		Valid = [0 for i in range(0,Len)]
		Valid[0] = True
		for i in range(1,Len):
			for j in range(0,i):
				Valid[i] = (Valid[j]) and (s[j+1:i+1] in dict)
				if Valid[i]:break
		return Valid[Len-1]