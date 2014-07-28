class Solution:
    # @return an integer
    def numTrees(self, n):
		if n == 0:
			return 1
		if n == 1:
			return 1
		countList=[]
		countList.append(1)
		countList.append(1)
		for i in range(2,n+1):
			countList.append(0)
			for j in range(0,j):
				countList[i] = countList[i] + countList[j]*countList[i-j-1]
		return countList[n]