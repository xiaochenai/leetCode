# Given a linked list, swap every two adjacent nodes and return its head.

# For example,
# Given 1->2->3->4, you should return the list as 2->1->4->3.

# Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param a ListNode
    # @return a ListNode
    def swapPairs(self, head):
		if head == None:
			return None
		if head.next == None:
		        return head
		nd = head
		pre = None
		newhead = head.next
		while nd != None:
			nd2 = nd.next
			if nd2 != None:
				if pre != None:
					pre.next = nd2
				pre = nd
				nd.next = nd2.next
				nd2.next = nd
				nd = nd.next
			else:
				nd = nd.next
		return newhead