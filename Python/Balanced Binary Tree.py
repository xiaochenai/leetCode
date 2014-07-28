# Given a binary tree, determine if it is height-balanced.

# For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
	def isBalanced(self, root):
		if root is None:
			return True
		if self.getDepth(root) == -1: return False
		return True
		
		
	def getDepth(self,node):
		if node == None:
			return 0
		left = self.getDepth(node.left)
		if left == -1:
			return -1
		right = self.getDepth(node.right)
		if right == -1:
			return -1
		if (left-right > 1) or (right - left > 1):
			return -1
		if left > right:
			return left+1
		else:
			return right+1
			