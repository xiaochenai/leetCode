class Solution:
    # @return a boolean
    def isPalindrome(self, x):
		if x < 0:
			return False
		tail = x
		head = x
		e = 10
		leng = 1
		while x/10 > 0:
			leng = leng * 10
			x = x / 10
		while leng >= e:
			chead = head/leng
			ctail = tail%10
			if chead != ctail:
				return False
			head = head % leng
			tail = tail/10
			leng = leng/10
			e = e * 10
		return True