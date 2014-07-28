# Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

# Note: You may not slant the container
class Solution:
    # @return an integer
    def maxArea(self, height):
		lenH = len(height)
		contain = 0
		if lenH < 2:
			return 0
		end = lenH-1
		maxV=0
		i=0
		while i<end:
			contain = min(height[i],height[end])*(end - i)
			maxV = max(maxV,contain)
			if height[i] <= height[end]:
				i = i + 1
			else:
				end = end -1
		return maxV