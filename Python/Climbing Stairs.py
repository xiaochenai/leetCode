
# You are climbing a stair case. It takes n steps to reach to the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
#recursive
class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
		if n == 1:
			return 1
		if n == 2:
			return 2
		return self.climbStairs(n-1) + self.climbStairs(n-2)
		
		
#iterative

        #recursive
class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
		if n == 1:
			return 1
		if n == 2:
			return 2
		fn_1 = 2
		fn_2 = 1
		for i in range (3,n+1):
			fn = fn_1 + fn_2
			fn_2 = fn_1
			fn_1 = fn
		return fn
		
#