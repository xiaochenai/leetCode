# Given a non-negative number represented as an array of digits, plus one to the number.

# The digits are stored such that the most significant digit is at the head of the list.

class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
		carry = 1
		sum = 0
		result = [0 for i in xrange(len(digits))]
		for i in range(len(digits)-1,-1,-1):
			sum = carry + digits[i]
			carry = sum/10
			result[i] = sum%10
		if carry > 0:
			result.insert(0,carry)
		return result