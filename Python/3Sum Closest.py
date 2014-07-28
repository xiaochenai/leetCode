# Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    # For example, given array S = {-1 2 1 -4}, and target = 1.

    # The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	
	
class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
		num.sort()
		leng = len(num)
		minV = 65536
		record = 0
		for i in range(0,leng):
			start = i + 1
			end = leng - 1
			while start < end:
				sum = num[i] + num[start] + num[end]
				if sum == target:
					minV = 0
					record = sum
					break
				if sum < target:
					if (target - sum) < minV:
						minV = target - sum
						record = sum
					start = start + 1
				else:
					if sum - target < minV:
						minV = sum - target
						record = sum
					end = end - 1
			while i < leng -1 and num[i] == num[i+1]:
				i = i + 1
		return record