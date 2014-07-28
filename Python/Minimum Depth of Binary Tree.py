# Given a binary tree, find its minimum depth.

# The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
		if root == None:
			return 0
		lmin = self.minDepth(root.left)
		rmin = self.minDepth(root.right)
		if lmin == 0 and rmin == 0:
			return 1
		if lmin == 0:
			lmin = rmin + 1
		if rmin == 0:
			rmin = lmin + 1
		return min(lmin,rmin) + 1
		
class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
		if root == None:
			return 0
		s1 = []
		s2 = []
		s1.append(root)
		count = 1
		while len(s1) != 0 or len(s2) != 0:
			while len(s1) != 0:
				tempNode = s1.pop(0)
				if tempNode.left == None  and tempNode.right == None:
					return count
				if tempNode.left != None:
					s2.append(tempNode.left)
				if tempNode.right != None:
					s2.append(tempNode.right)
			count = count + 1
			s1 = list(s2)
			s2 = []
		return count
			