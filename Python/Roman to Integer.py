
# Given a roman numeral, convert it to an integer.

# Input is guaranteed to be within the range from 1 to 3999.
# 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
# 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
# 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
# 但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
# 左减数字必须为一位，比如8写成VIII，而非IIX。
# 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）
class Solution:
    # @return an integer
    def romanToInt(self, s):
		result = 0
		length = len(s)
		for i in range(0,length):
			if (i>0) and (self.c2n(s[i]) > self.c2n(s[i-1])):
				result = result + self.c2n(s[i]) - 2*self.c2n(s[i-1])
			else:
				result = result + self.c2n(s[i])
		return result
    def c2n(self,char):
		if char == "I":return 1
		if char == "V":return 5
		if char == "X":return 10
		if char == "L":return 50
		if char == "C":return 100
		if char == "D":return 500
		if char == "M":return 1000
		return 0