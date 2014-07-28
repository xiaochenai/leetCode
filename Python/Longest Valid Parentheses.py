class Solution:
    # @param s, a string
    # @return an integer
    def longestValidParentheses(self, s):
		Len, stack, maxLen = len(s), [(-1,")")], 0
		for i in xrange(Len):
			if s[i] == ")" and stack[-1][1]=="(":
				stack.pop()
				maxLen = max(maxLen,i-stack[-1][0])
			else:
				stack.append((i,s[i]))
		return maxLen