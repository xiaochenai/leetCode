# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# O(n)
class Solution:
    # @param root, a tree node
    # @return a tree node
	def recoverTree(self, root):
		self.n1 = None
		self.n2 = None
		self.prev = None
		self.proc(root)
		if self.n1 and self.n2:
			temp = self.n1.val
			self.n1.val = self.n2.val
			self.n2.val = temp
		return root
	def proc(self,root):
		if root == None:
			return
		self.proc(root.left)
		if self.prev == None:
			self.prev = root
		if self.n1 == None and self.prev.val > root.val:
			self.n1 = self.prev
			self.n2 = root
		elif self.prev.val > root.val:
			self.n2 = root
		self.prev = root
		self.proc(root.right)
		return
		
		
class Solution:
    # @param root, a tree node
    # @return a tree node
	def recoverTree(self, root):
		n1 = None
		n2 = None
		prev = None
		self.proc(root,n1,n2,prev)
		if n1 and n2:
			temp = n1.val
			n1.val = n2.val
			n2.val = temp
		return root
	def proc(self,root,n1,n2,prev):
		if root == None:
			return
		self.proc(root.left,n1,n2,prev)
		if prev and prev.val > root.val:
			n2 = root
			if not n1:
				n1 = prev
		prev = root
		self.proc(root.right,n1,n2,prev)
	def change(self,a):
		a = TreeNode(10)

		
a = TreeNode(0)
b = None
s =Solution()
s.change(b)
print b.val