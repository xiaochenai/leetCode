# A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

# Return a deep copy of the list.


# Definition for singly-linked list with a random pointer.
# class RandomListNode:
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):
		current = head
		while current != None:
			temp = RandomListNode(current.label)
			temp.next = current.next
			current.next = temp
			current = temp.next
		current = head
		while current != None:
			temp = current.next
			if current.random != None:
				temp.random = current.random.next
			current = temp.next
		current = head
		if head == None: 
			dup = None 
		else: 
			dup = head.next
		while current != None:
			temp = current.next
			current.next = temp.next
			if temp.next != None:
				temp.next = current.next.next
			current = current.next
		return dup

class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):