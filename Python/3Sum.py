class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
		sortedNum = sorted(num)
		res=[]
		for i in range(len(num)-2):
			a = sortedNum[i]
			j = i+1
			k = len(num)-1
			if i >= 1 and a == sortedNum[i-1]:
				continue
			while j<k:
				b = sortedNum[j]
				c = sortedNum[k]
				if a+b+c==0:
					res.append([a,b,c])
					while j<k:
						j = j + 1
						k = k - 1
						if sortedNum[j]!=b or sortedNum[k]!=c:
							break
				elif a+b+c>0:
					while j<k:
						k = k - 1
						if c != sortedNum[k]:
							break
				else:
					while j<k:
						j = j + 1
						if b != sortedNum[j]:
							break
		return res
