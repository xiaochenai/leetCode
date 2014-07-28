# Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a list node
    # @return a tree node
	listNode = TreeNode(0)
	def sortedListToBST(self, head):
		leng = 0
		p = head
		while p!=None:
			leng = leng + 1
			p = p.next
		self.listNode = head
		return self.buildBST(0,leng-1)
	def buildBST(self,start,end):
		if start > end:
			return None
		mid = (start + end)/2
		leftC = self.buildBST(start,mid - 1)
		parent = TreeNode(self.listNode.val)
		parent.left = leftC
		self.listNode = self.listNode.next
		parent.right = self.buildBST(mid+1,end)
		return parent