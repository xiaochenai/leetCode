class Solution:
	# @param matrix, a list of lists of integers
	# @return a list of integers
	def spiralOrder(self, matrix):
		if len(matrix) == 0:
			return []
		m = len(matrix)
		n = len(matrix[0])
		res = []
		top = 0
		bot = m-1
		left = 0
		right = n-1
		while left<right and top < bot:
			for j in range(left,right):
				res.append(matrix[top][j])
			for j in range(top,bot):
				res.append(matrix[j][right])
			for j in range(right,left,-1):
				res.append(matrix[bot][j])
			for j in range(bot,top,-1):
				res.append(matrix[j][left])
			if left < right:
				left = left + 1
				right = right - 1
			if top < bot:
				top = top + 1
				bot = bot - 1
		if top == bot and left!=right:
			for j in range(left,right+1):
				res.append(matrix[top][j])
		if left == right and top!=bot:
			for j in range(top,bot+1):
				res.append(matrix[j][right])
		if left == right and top == bot:
			res.append(matrix[top][left])
		return res
a = [[6,6]]
s = Solution()
s.spiralOrder(a)