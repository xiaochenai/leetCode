class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# old code failed
# class Solution:
    # # @param p, a tree node
    # # @param q, a tree node
    # # @return a boolean
    # def isSameTree(self, p, q):
		# if p == None and q== None:
			# return True
		# elif ((p is not None) and (q is not None)):
			# if q.val is not p.val:
				# return False
			# else:
				# return (self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right) )
		# else:
			# return False
			
# refined old code accepted
# class Solution:
    # # @param p, a tree node
    # # @param q, a tree node
    # # @return a boolean
    # def isSameTree(self, p, q):
		# if p == None and q== None:
			# return True
		# elif ( (p != None) and (q != None)):
			# if (q.val != p.val):
				# return False
			# else:
				# return (self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right) )
		# else:
			# return False
			
class Solution:
    # @param p, a tree node
    # @param q, a tree node
    # @return a boolean
    def isSameTree(self, p, q):
		if p == q == None:
			return True
		if not (p and q) or p.val != q.val:
			return False
		return self.isSameTree(p.left,q.left) and self.isSameTree(q.right,p.right)