# Given a binary tree, determine if it is a valid binary search tree (BST).

# Assume a BST is defined as follows:

# The left subtree of a node contains only nodes with keys less than the node's key.
# The right subtree of a node contains only nodes with keys greater than the node's key.
# Both the left and right subtrees must also be binary search trees.

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
	def isValidBST(self, root):
		return self.verifyBST(root,False,False,0,0)
	def verifyBST(self,root,left,right,lMax,rMin):
		if root == None:
			return True
		if left and root.val >= lMax:
			return False
		if right and root.val <=rMin:
			return False
		leftValid = self.verifyBST(root.left,True,right,root.val,rMin)
		rightValid = self.verifyBST(root.right,left,True,lMax,root.val)
		return leftValid and rightValid