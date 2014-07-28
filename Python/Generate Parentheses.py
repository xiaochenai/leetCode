# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

# For example, given n = 3, a solution set is:

# "((()))", "(()())", "(())()", "()(())", "()()()"


class Solution:
    # @param an integer
    # @return a list of string
	def generateParenthesis(self, n):
		result = []
		currentList = ""
		total = 0
		left = 0
		right = 0
		if n == 0:
			return result
		self.ParenthesisGenerator(total,n,left,right,currentList,result)
		return result
	def ParenthesisGenerator(self,total,n,left,right,currentList,result):
		if total == 2*n:
			result.append(currentList)
			return
		if left < n:
			currentList = currentList + "("
			self.ParenthesisGenerator(total+1,n,left+1,right,currentList,result)
			currentList = currentList[0:len(currentList)-1]
		if right < left :
			currentList = currentList + ")"
			self.ParenthesisGenerator(total+1,n,left,right+1,currentList,result)
			currentList = currentList[0:len(currentList)-1]