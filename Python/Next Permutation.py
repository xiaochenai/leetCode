# Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

# If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

# The replacement must be in-place, do not allocate extra memory.

# Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
# 1,2,3 → 1,3,2
# 3,2,1 → 1,2,3
# 1,1,5 → 1,5,1


class Solution:
    # @param num, a list of integer
    # @return a list of integer
    def nextPermutation(self, num):
		if len(num) <= 0:
			return []
		vioIndex = len(num) - 1
		while vioIndex > 0:
			if num[vioIndex-1] < num[vioIndex]:
				break
			vioIndex = vioIndex - 1
		if vioIndex > 0:
			vioIndex = vioIndex - 1
			rightIndex = len(num) - 1
			while rightIndex >= 0 and num[rightIndex] <= num[vioIndex]:
				rightIndex = rightIndex - 1
			swap = num[vioIndex]
			num[vioIndex] = num[rightIndex]
			num[rightIndex] = swap
			vioIndex = vioIndex + 1
		end = len(num) - 1
		while end > vioIndex:
			swap = num[vioIndex]
			num[vioIndex] = num[end]
			num[end] = swap
			end = end - 1
			vioIndex =vioIndex + 1
		return num