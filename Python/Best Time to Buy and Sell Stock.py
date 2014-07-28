# Say you have an array for which the ith element is the price of a given stock on day i.

# If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
		if len(prices) == 0:
			return 0
		maxV = 0
		diff = 0
		minV = prices[0]
		for i in range(0,len(prices)):
			if minV > prices[i]:
				minV = prices[i]
			diff = prices[i] - minV
			if maxV < diff:
				maxV = diff
		return maxV
		