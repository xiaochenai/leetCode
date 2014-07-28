# Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

# For example:
# Given binary tree {3,9,20,#,#,15,7},
    # 3
   # / \
  # 9  20
    # /  \
   # 15   7
# return its zigzag level order traversal as:
# [
  # [3],
  # [20,9],
  # [15,7]
# ]

# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def zigzagLevelOrder(self, root):
		result = []
		if root == None:
			return result
		order = True
		toVisit = []
		toVisit.append(root)
		while len(toVisit) != 0:
			next = []
			temp = []
			for ele in toVisit:
				temp.append(ele.val)
			result.append(list(temp))
			while len(toVisit) != 0:
				node = toVisit.pop()
				if order:
					if node.right != None:
						next.append(node.right)
					if node.left != None:
						next.append(node.left)
				else:
					if node.left != None:
						next.append(node.left)
					if node.right != None:
						next.append(node.right)
			order = not order
			toVisit = list(next)
		return result
				