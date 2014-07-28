# Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

# If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

# You may not alter the values in the nodes, only nodes itself may be changed.

# Only constant memory is allowed.

# For example,
# Given this linked list: 1->2->3->4->5

# For k = 2, you should return: 2->1->4->3->5

# For k = 3, you should return: 3->2->1->4->5


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def reverseKGroup(self, head, k):
		safeG = ListNode(-1)
		safeG.next = head
		if head == None or k == 1:
			return head
		pre = safeG
		current = head
		post = head.next
		while current != None:
			post = current.next
			i = 0
			while i < (k-1) and post != None:
				temp = post.next
				post.next = current
				current = post
				post = temp
				i = i + 1
			if i != (k-1):
				k = 0
				temp = post
				post =current
				current = temp
				while k < i:
					temp = post.next
					post.next = current
					current = post
					post = temp
					k = k + 1
				break
			temp = pre.next
			pre.next = current
			temp.next = post
			pre = temp
			current = pre.next
		head = safeG.next
		return head