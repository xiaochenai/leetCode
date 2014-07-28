# Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

# You should preserve the original relative order of the nodes in each of the two partitions.

# For example,
# Given 1->4->3->2->5->2 and x = 3,
# return 1->2->2->4->3->5.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param x, an integer
    # @return a ListNode
    def partition(self, head, x):
		p = ListNode(x-1)
		p.next = head
		head = p
		while p != None and p.val < x:
			pre = p
			p = p.next
		if p != None:
			current = pre
			while p != None:
				if p.val < x:
					temp = current.next
					pre.next = p.next
					current.next = p
					current = p
					p.next = temp
					p = pre
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				pre = p
				p = p.next
		temp = head
		head = head.next
		return head