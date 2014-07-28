# Reverse a linked list from position m to n. Do it in-place and in one-pass.

# For example:
# Given 1->2->3->4->5->NULL, m = 2 and n = 4,

# return 1->4->3->2->5->NULL.

# Note:
# Given m, n satisfy the following condition:
# 1 ≤ m ≤ n ≤ length of list.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
		step = n - m
		safeG = ListNode(-1)
		safeG.next = head
		head = safeG
		pre = head
		while m > 1:
			pre = pre.next
			m = m - 1
		current = pre.next
		post = current.next
		if step >= 1:
			while step > 0 and post != None:
				temp = post.next
				post.next = current
				current = post
				post = temp
				step = step - 1
			temp = pre.next
			pre.next = current
			temp.next = post
		safeG = head
		head = head.next
		return head