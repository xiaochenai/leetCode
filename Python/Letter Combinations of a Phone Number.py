class Solution:
    # @return a list of strings, [s1, s2]
	def letterCombinations(self, digits):
		trans = [""," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
		set = []
		seq = ""
		self.generator(trans,digits,0,seq,set)
		return set
	def generator(self,trans,digits,deep,result,set):
		if deep == len(digits):
			newS = result+""
			set.append(newS)
			return
		currentDigit = digits[deep]
		for i in range(0,len(trans[int(currentDigit)])):
			result = result + (trans[int(currentDigit)][i])
			self.generator(trans,digits,deep+1,result,set)
			result = result[0:len(result)-1]