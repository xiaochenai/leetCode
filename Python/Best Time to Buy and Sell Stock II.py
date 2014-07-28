class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
		sum = 0
		for i in range(1,len(prices)):
			diff = prices[i] - prices[i-1]
			if diff > 0:
				sum = sum + diff
		return sum