# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

# The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


class Solution:
    # @return a boolean
	def isValid(self, s):
		if len(s)%2 != 0:
			return False
		if len(s) == 0:
			return True
		mid = len(s)/2
		lmid = mid - 1
		while mid != len(s):
			if self.isValidPair(s[lmid],s[mid]) == False:
				return False
			mid = mid + 1
			lmid = lmid -1
	def isValidPair(self,s1,s2):
		if s == "(":return ")"
		if s == "[":return "]"
		if s == "{":return "}"
		return s
class Solution:
    # @return a boolean
	def isValid(self, s):
		if len(s) == 0:
			return False
		stack = []
		stack.append(s[0])
		for i in range(1,len(s)):
			if s[i] == "(" or s[i] == "[" or s[i] == "{":
				stack.append(s[i])
				continue
			else:
				if len(stack) == 0:
					return False
				current = stack.pop()
				if s[i] == ")" and current != "(":
					return False
				if s[i] == "]" and current != "[":
					return False
				if s[i] == "}" and current != "{":
					return False
		if len(stack) != 0:
			return False
		return True