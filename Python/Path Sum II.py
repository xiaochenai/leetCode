# Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

# For example:
# Given the below binary tree and sum = 22,
              # 5
             # / \
            # 4   8
           # /   / \
          # 11  13  4
         # /  \    / \
        # 7    2  5   1
# return
# [
   # [5,4,11,2],
   # [5,8,4,5]
# ]


# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
	def pathSum(self, root, Sum):
		currentSum = 0
		current = []
		solution = []
		if root != None:
			self.pathSolution(root,Sum,current,solution,currentSum)
		return solution
	def pathSolution(self,root,Sum,current,solution,currentSum):
		currentSum = currentSum + root.val
		current.append(root.val)
		if currentSum == Sum and root.left == None and root.right == None:
			solution.append(list(current))
		else:
			if root.left != None:
				self.pathSolution(root.left,Sum,current,solution,currentSum)
			if root.right != None:
				self.pathSolution(root.right,Sum,current,solution,currentSum)
		current.pop()
		currentSum = currentSum - root.val
		return