# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
	maxAcrossRoot = -65536
	def maxPathSum(self, root):
		maxEndByRoot = self.getMax(root,self.maxAcrossRoot)
		return max(self.maxAcrossRoot,maxEndByRoot)
	def getMax(self,node,maxAcrossRoot):
		if node == None:
			return 0
		left = self.getMax(node.left,self.maxAcrossRoot)
		right = self.getMax(node.right,self.maxAcrossRoot)
		cMax = node.val
		if left > 0:
			cMax = cMax + left
		if right > 0:
			cMax = cMax + right
		self.maxAcrossRoot = max(self.maxAcrossRoot,cMax)
		return max(node.val,max(node.val+left,node.val+right))
		
		
#another solution# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
	def maxPathSum(self, root):
	