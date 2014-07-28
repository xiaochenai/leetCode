# Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
		ls1 = l1
		ls2 = l2
		head = ListNode(-1)
		p =head
		if l1 == None:
			return l2
		if l2 == None:
			return l1
		while ls1 != None and ls2 != None:
			if ls1.val < ls2.val :
				p.next = ls1
				ls1 = ls1.next
			else:
				p.next = ls2
				ls2 = ls2.next
			p = p.next
		if ls1 != None:
			p.next = ls1
		if ls2 != None:
			p.next = ls2
		p = head.next
		return p