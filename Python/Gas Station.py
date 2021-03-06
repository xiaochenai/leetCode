# There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

# You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

# Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

# Note:
# The solution is guaranteed to be unique.
class Solution:
    # @param gas, a list of integers
    # @param cost, a list of integers
    # @return an integer
    def canCompleteCircuit(self, gas, cost):
		leng = len(gas)
		diff = [0 for i in range(0,leng)]
		for i in range(0,len(gas)):
			diff[i] = gas[i] - cost[i]
		leftGas = 0
		sum = 0
		startNode = 0
		for i in range(0,len(gas)):
			leftGas = leftGas + diff[i]
			sum = sum + diff[i]
			if sum<0:
				startNode = i + 1
				sum = 0
		if leftGas < 0:
			return -1 
		else:
			return startNode