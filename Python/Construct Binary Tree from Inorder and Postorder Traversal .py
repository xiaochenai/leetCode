# Given inorder and postorder traversal of a tree, construct the binary tree.


# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param preorder, a list of integers
    # @param inorder, a list of integers
    # @return a tree node
	def buildTree(self, preorder, inorder):
		return self.reBuildTree(inorder,0,len(inorder)-1,preorder,0,len(preorder)-1)
	def reBuildTree(self,inorder,inStart,inEnd,preorder,pStart,pEnd):
		if inStart>inEnd or pStart>pEnd:
			return None
		root = TreeNode(preorder[pStart])
		k=0
		for i in range(0,len(inorder)):
			if inorder[i] == root.val:
				k=i
				break
		root.left = self.reBuildTree(inorder,inStart,k-1,preorder,pStart+1,pStart+k-(inStart))
		root.right = self.reBuildTree(inorder,k+1,inEnd,preorder,pStart+k-inStart+1,pEnd)
		return root