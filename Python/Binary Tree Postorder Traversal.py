# Given a binary tree, return the postorder traversal of its nodes' values.

# For example:
# Given binary tree {1,#,2,3},
   # 1
    # \
     # 2
    # /
   # 3
# return [3,2,1].

# Note: Recursive solution is trivial, could you do it iteratively?

# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# method 1
class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
		s = []
		result = []
		rt = []
		if root == None:
			return result
		s.append(root)
		while len(s) != 0:
			current = s.pop()
			result.append(current)
			if current.left != None:
				s.append(current.left)
			if current.right != None:
				s.append(current.right)
		while len(result) != 0:
			rt.append(result.pop().val)
		return rt
		
#method 2