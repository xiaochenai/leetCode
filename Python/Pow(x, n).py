# Implement pow(x, n).


class Solution:
    # @param x, a float
    # @param n, a integer
    # @return a float
	def pow(self, x, n):
		if n < 0:
			return 1.0/self.power(x,-n)
		else:
			return self.power(x,n)
	def power(self,x,n):
		if n == 0:
			return 1
		v = float(self.power(x,n/2))
		if n%2 == 0:
			return float(v*v)
		else:
			return float(v*v*x)