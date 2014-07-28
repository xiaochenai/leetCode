# Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

# For example, this binary tree is symmetric:

    # 1
   # / \
  # 2   2
 # / \ / \
# 3  4 4  3
# But the following is not:
    # 1
   # / \
  # 2   2
   # \   \
   # 3    3
# Note:
# Bonus points if you could solve it both recursively and iteratively.

# confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
		if root == None:
			return True
		left = []
		right = []
		level = 1
		left.append(root.left)
		right.append(root.right)
		while (len(left) * len(right) != 0):
			templeft = left.pop()
			tempright = right.pop()
			if (templeft == None and tempright != None) or (templeft != None and tempright == None):
				return False
			if templeft != None:
				if templeft.val != tempright.val:
					return False
				left.append(templeft.left)
				left.append(templeft.right)
				right.append(tempright.right)
				right.append(tempright.left)
		return True
		
#recursively
class Solution:
    # @param root, a tree node
    # @return a boolean
	def isSymmetric(self, root):
		if root == None:
			return True
		return self.Symmetric(root.left,root.right)
	def Symmetric(self,leftnode, rightnode):
		if leftnode == None:
			if rightnode == None:
				return True
			else:
				return False
		if rightnode == None:
			return False
		if (leftnode.val != rightnode.val):
			return False
		
		return (self.Symmetric(leftnode.left,rightnode.right) and self.Symmetric(rightnode.left,leftnode.right))