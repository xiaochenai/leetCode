# Say you have an array for which the ith element is the price of a given stock on day i.

# Design an algorithm to find the maximum profit. You may complete at most two transactions.

#not accepted
class Solution:
    # @param prices, a list of integer
    # @return an integer
	def maxProfit(self, prices):
		index = 0
		max1 = 0
		max2 = 0
		Max = 0
		for i in range(0,len(prices)):
			max1 = self.searchMax(prices,0,i)
			max2 = self.searchMax(prices,i+1,len(prices)-1)
			if Max < (max1+max2):
				Max = max1 + max2	
		return Max
	def searchMax(self,prices,start,end):
		Max = 0
		Min = 65536
		for i in range(start,end+1):
			if Min > prices[i]:
				Min = prices[i]
			diff = prices[i] - Min
			if diff > Max:
				Max = diff
		return Max
#accepted http://chaoren.is-programmer.com/posts/43727.html
class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        length = len(prices)
        if length == 0: return 0
         
        maxProfitForward = []
        minPrice = prices[0]
        maxProfit = -1
        for currPrice in prices:
            minPrice = min(minPrice, currPrice)
            maxProfit = max(maxProfit, currPrice - minPrice)
            maxProfitForward.append(maxProfit)
         
        maxProfitBackward = []
        maxPrice = prices[-1]
        maxProfit  = -1
        for currPrice in reversed(prices):
            maxPrice = max(maxPrice, currPrice)
            maxProfit = max(maxProfit, maxPrice - currPrice)
            maxProfitBackward.insert(0, maxProfit)
         
        maxProfit = maxProfitForward[-1] # 0 or 1 transaction
        for i in xrange(length - 1): # 2 transactions
            maxProfit = max(maxProfit, maxProfitForward[i] + maxProfitBackward[i + 1])
        return maxProfit