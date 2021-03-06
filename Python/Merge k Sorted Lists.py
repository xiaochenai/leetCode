# Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
 
class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        heap = []
        for node in lists:
            if node != None: heap.append((node.val, node))
        heapq.heapify(heap)
        head = ListNode(0); curr = head
        while heap:
            pop = heapq.heappop(heap)
            curr.next = ListNode(pop[0])
            curr = curr.next
            if pop[1].next: heapq.heappush(heap, (pop[1].next.val, pop[1].next))
        return head.next