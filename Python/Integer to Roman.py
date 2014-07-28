# Given an integer, convert it to a roman numeral.

# Input is guaranteed to be within the range from 1 to 3999.

class Solution:
    # @return a string
    def intToRoman(self, num):
		romList = ["I","V","X","L","C","D","M"]
		scale = 1000
		roman = ""
		for i in range(6,-1,-2):
			digit = num/scale
			if digit != 0:
				if digit <= 3:
					for j in xrange(0,digit):
						roman = roman + romList[i]
				elif digit == 4:
					roman = roman + romList[i]
					roman = roman + romList[i+1]
				elif digit == 5:
					roman = roman + romList[i+1]
				elif digit <= 8:
					roman = roman + romList[i+1]
					for j in xrange(0,(digit-5)):
						roman = roman + romList[i]
				elif digit == 9:
					roman = roman + romList[i]
					roman = roman + romList[i+2] 
			num = num % scale
			scale = scale / 10
		return roman