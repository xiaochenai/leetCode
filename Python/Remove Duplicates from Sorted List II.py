# Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

# For example,
# Given 1->2->3->3->4->4->5, return 1->2->5.
# Given 1->1->1->2->3, return 2->3.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
		if head == None:
			return None
		safeG = ListNode(-65536)
		safeG.next = head
		current = safeG
		pre = head
		while pre != None:
			isDuplicate = False
			while pre.next != None and pre.val == pre.next.val:
				isDuplicate = True
				temp = pre
				pre = pre.next
				
			if isDuplicate:
				temp = pre
				pre = pre.next
				continue
			current.next = pre
			current = current.next
			pre = pre.next
		current.next = pre
		temp = safeG.next
		return temp