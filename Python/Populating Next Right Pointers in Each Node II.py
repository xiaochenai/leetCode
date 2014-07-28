# Follow up for problem "Populating Next Right Pointers in Each Node".

# What if the given tree could be any binary tree? Would your previous solution still work?

# Note:

# You may only use constant extra space.
# For example,
# Given the following binary tree,
         # 1
       # /  \
      # 2    3
     # / \    \
    # 4   5    7
# After calling your function, the tree should look like:
         # 1 -> NULL
       # /  \
      # 2 -> 3 -> NULL
     # / \    \
    # 4-> 5 -> 7 -> NULL
	
	
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
		if root == None:
			return
		p = root.next
		while p!= None:
			if p.left != None:
				p = p.left
				break
			if p.right != None:
				p = p.right
				break
			p = p.next
		if root.right != None:
			root.right.next = p
		if root.left != None:
			if root.right!= None:
				root.left.next = root.right
			else:
				root.left.next = p
		self.connect(root.right)
		self.connect(root.left)
		
class Solution:
    # @param root, a tree node
    # @return nothing
	def connect(self, root):
		cur = root
		next = None
		while cur != None:
			p = cur
			k = None
			while p != None:
				sub = self.linkedLeftNode(p)
				if sub != None:
					if next == None:
						next = sub
						k = sub
					else:
						k.next = sub
					while k.next != None:
						k = k.next
				p = p.next
			cur = next
			next = None
	def linkedLeftNode(self,root):
		if root.left != None and root.right != None:
			root.left.next = root.right
		if root.left != None:
			return root.left
		if root.right != None:
			return root.right
		return None