# The count-and-say sequence is the sequence of integers beginning as follows:
# 1, 11, 21, 1211, 111221, ...

# 1 is read off as "one 1" or 11.
# 11 is read off as "two 1s" or 21.
# 21 is read off as "one 2, then one 1" or 1211.
# Given an integer n, generate the nth sequence.

# Note: The sequence of integers will be represented as a string.


class Solution:
    # @return a string
    def countAndSay(self, n):
		prev = "1"
		curr = ""
		for i in range(2,n+1):
			p = 1
			lenPrev = len(prev)
			c = prev[0]
			count = 1
			while p < lenPrev:
				if prev[p] == c:
					count = count + 1
					p = p + 1
				else:
					curr = curr + str(count) + str(c)
					c = prev[p]
					count = 1
					p = p + 1
			curr = curr + str(count) + str(c)
			print curr
			prev = curr
			curr = ""
		return prev+""
s = Solution()
s.countAndSay(4)