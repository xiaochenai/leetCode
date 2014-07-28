class Solution:
    # @return an integer
    def atoi(self, str):
		str = str.strip()
		newStr = []
		for i in xrange(len(str)):
			if "0"<=str[i]<="9" or (i==0 and str[i] in ("+","-")):
				newStr.append(str[i])
			else:
				break
		if newStr in([],["+"],["-"]):
			return 0
		elif -2147483648 <= int(''.join(newStr)) <= 2147483647:
			return int(''.join(newStr))
		elif int(''.join(newStr)) > 2147483647:
			return 2147483647
		else:
			return -2147483648
s = Solution()
print s.atoi("123A")