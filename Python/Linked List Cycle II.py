# Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

# Follow up:
# Can you solve it without using extra space?

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
		first = head
		second = head
		while first != None and second != None:
			first = first.next
			second = second.next
			if second != None:
				second = second.next
			if first == second:
				break
		if second == None:
			return None
		first = head
		while first != second:
			first = first.next
			second = second.next
		return second