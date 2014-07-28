# Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

# For example:
# Given binary tree {3,9,20,#,#,15,7},
    # 3
   # / \
  # 9  20
    # /  \
   # 15   7
# return its bottom-up level order traversal as:
# [
  # [15,7]
  # [9,20],
  # [3],
# ]


# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def levelOrderBottom(self, root):
		if root == None:
			return []
		queue = []
		result = []
		result.append([root.val])
		queue.append(root.left)
		queue.append(root.right)
		while len(queue) != 0:
			currentList = []
			currentlen = len(queue)
			for i in range(0,currentlen):
				temp = queue.pop(0)
				if temp != None:
					queue.append(temp.left)
					queue.append(temp.right)
					currentList.append(temp.val)
			if len(currentList) != 0 :
			    result.insert(0,currentList)
		return result