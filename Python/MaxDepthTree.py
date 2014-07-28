class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def maxDepth(self, root):
		maxDep = 0
		if root is None:
			return maxDep
		leftDep = self.maxDepth(root.left)
		rightDep = self.maxDepth(root.right)
		return 1 + max(leftDep,rightDep)
		