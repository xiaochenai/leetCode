# Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

# For example,
# Given n = 3, your program should return all 5 unique BST's shown below.

   # 1         3     3      2      1
    # \       /     /      / \      \
     # 3     2     1      1   3      2
    # /     /       \                 \
   # 2     1         2                 3
   
   
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @return a list of tree node
	def generateTrees(self, n):
		if n == 0:
			return self.generate(1,0)
		return self.generate(1,n)
	def generate(self,start,end):
		subTree = []
		if start > end:
			subTree.append(None)
			return subTree
		for i in range(start,end+1):
			leftSub = self.generate(start,i-1)
			rightSub = self.generate(i+1,end)
			for j in range(0,len(leftSub)):
				for k in range(0,len(rightSub)):
					node = TreeNode(i)
					node.left = leftSub[j]
					node.right = rightSub[k]
					subTree.append(node)
		return subTree