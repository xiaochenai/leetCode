# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def inorderTraversal(self, root):
		stack = []
		result = []
		current = root
		if current == None:
			return result
		while ((stack != None) or (current != None)):
			if current != None:
				stack.append(current)
				current = current.left
			else:
				current = stack.pop()
				result.append(current.val)
				current = current.right
		return result