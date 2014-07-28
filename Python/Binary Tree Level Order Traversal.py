# Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

# For example:
# Given binary tree {3,9,20,#,#,15,7},
    # 3
   # / \
  # 9  20
    # /  \
   # 15   7
# return its level order traversal as:
# [
  # [3],
  # [9,20],
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
    def levelOrder(self, root):
		result = []
		stack = []
		temp = []
		level = []
		if root == None:
			return result
		stack.append(root)
		while len(stack) != 0:
			current = stack.pop(0)
			if current.left != None:
				temp.append(current.left)
			if current.right != None:
				temp.append(current.right)
			level.append(current.val)
			if len(stack) == 0:
				stack = list(temp)
				result.append(list(level))
				temp = []
				level = []
		return result