class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
		stack = []
		width = []
		top = 0
		area = 0
		newheight = 0
		stack.append(0)
		width.append(0)
		for i in range(0,len(height)+1):
			if  i < len(height):
				newheight = height[i]
			else:
				newheight = -1
			if newheight >= stack[len(stack)-1]:
				stack.append(newheight)
				width.append(1)
			else:
				minV = 2147483647
				wid = 0
				while len(stack) > 0 and stack[len(stack)-1] > newheight:
					minV = min(minV,stack.pop())
					wid = wid + width.pop()
					area = max(area,minV*(wid))
				stack.append(newheight)
				width.append(wid+1)
		return area
		
class Solution:
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
		stack = []
		area = 0
		newheight = 0
		height.append(0)
		i=0
		while i < len(height):
			if len(stack)==0 or height[i] > height[stack[len(stack)-1]]:
				stack.append(i)
				i = i + 1
			else:
				Min = stack.pop()
				if len(stack) == 0:
					wid = i
				else:
					wid = i - stack[len(stack)-1] -1
				area = max(area,height[Min]*wid)
		return area