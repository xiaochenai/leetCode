# Given an array where elements are sorted in ascending order, convert it to a height balanced BST

# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param num, a list of integers
    # @return a tree node
    def sortedArrayToBST(self, num):
		if len(num) == 0:
			return None
		mid = len(num)/2
		root = TreeNode(num[mid])
		left = self.sortedArrayToBST(num[0:mid])
		right = self.sortedArrayToBST(num[mid+1:len(num)])
		root.left = left
		root.right = right
		return root