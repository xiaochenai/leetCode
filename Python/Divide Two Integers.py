class Solution:
    # @return an integer
    def divide(self, dividend, divisor):
        sign = 1 if (dividend > 0 and divisor > 0) or (dividend < 0 and divisor < 0) else -1
        dividend = abs(dividend)
        divisor = abs(divisor)
        quotient = 0
        while dividend >= divisor:
			k = 0; tmp = divisor
			print tmp
			while dividend >= tmp:
				quotient += 1 << k
				print "que",quotient
				dividend -= tmp
				print "dividend",dividend
				tmp <<= 1
				print "tmp for next",tmp
				print "k",k
				k += 1
        return quotient * sign
s = Solution()
s.divide(25,1)