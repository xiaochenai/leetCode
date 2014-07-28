#Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        if head == None:
            return False
		else:
			onestep = head
			doublestep = head.next
			while (onestep != None and doublestep != None):
				if onestep == doublestep:
					return True
				onestep = onestep.next
				doublestep = doublestep.next
				if doublestep != None:
					doublestep = doublestep.next
			return False
			
#Method 2 
class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        