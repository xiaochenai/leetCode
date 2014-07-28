# Given a binary tree, flatten it to a linked list in-place.

# For example,
# Given

         # 1
        # / \
       # 2   5
      # / \   \
     # 3   4   6
# The flattened tree should look like:
   # 1
    # \
     # 2
      # \
       # 3
        # \
         # 4
          # \
           # 5
            # \
             # 6
			 
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return nothing, do it in place
	def flatten(self, root):
		if root == None:
			return
		self.convert(root)
	def convert(self,root):
		if root.left == None and root.right == None:
			return root
		rHead = None
		if root.right != None:
			rHead = self.convert(root.right)
		p = root
		if root.left != None:
			lHead = self.convert(root.left)
			root.right = lHead
			lHead.left = None
			root.left = None
			while p.right != None:
				p = p.right
		if rHead != None:
			p.right = rHead
			rHead.left = None
		return root