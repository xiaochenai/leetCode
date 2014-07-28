# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
###
### O(nlgn) sort algorithm quick sort heap sort and merge sort
class Solution:
    # @param head, a ListNode
    # @return a ListNode
	Head=ListNode(0)
	def sortList(self, head):
		if head == None:
			return None
		Len = 0
		it = head
		self.Head = head
		while it!=None:
			Len = Len + 1
			it = it.next
		newHead = self.Sort(self.Head,Len)
		return newHead
	def Sort(self,Head,Len):
		if Len == 1:
			temp = self.Head
			self.Head = self.Head.next
			temp.next = None
			return temp
		leftHead = self.Sort(self.Head,Len/2)
		rightHead = self.Sort(self.Head,Len-Len/2)
		newHead = self.merge(leftHead,rightHead)
		return newHead
	def merge(self,first,second):
		h = ListNode(-1)
		cur = h
		while first!=None or second!=None:
			fv = 65536 if first==None else first.val
			sv = 65536 if second==None else second.val
			if fv<=sv:
				cur.next = first
				first = first.next
			else:
				cur.next = second
				second = second.next
			cur = cur.next
		cur = h.next
		return cur
		
class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        length = 0
        curr = head;
        while curr != None:
            length += 1
            curr = curr.next
        return self.mergeSort(head, length)
     
    def mergeSort(self, head, length):
        # base case
        if length == 1 or length == 0: return head
         
        # sort the two halves of the list
        prev = curr = head
        for i in xrange(length / 2): curr = curr.next
        for i in xrange(length / 2 - 1): prev = prev.next
        prev.next = None
        head1 = self.mergeSort(head, length / 2)
        head2 = self.mergeSort(curr, length - length / 2)
         
        # merge sorted halves into one
        if head1.val <= head2.val: 
            curr = newHead = ListNode(head1.val)
            head1 = head1.next
        else: 
            curr = newHead = ListNode(head2.val)
            head2 = head2.next
        while head1 and head2:
            if head1.val <= head2.val:
                curr.next = ListNode(head1.val)
                head1 = head1.next
            else:
                curr.next = ListNode(head2.val)
                head2 = head2.next
            curr = curr.next
        while head1:
            curr.next = ListNode(head1.val)
            head1 = head1.next
            curr = curr.next
        while head2:
            curr.next = ListNode(head2.val)
            head2 = head2.next
            curr = curr.next
        return newHead
		