/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //the use of PriorityQueue
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0)
            return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
        new Comparator<ListNode>(){
			public int compare(ListNode l1,ListNode l2){
				return l1.val-l2.val;
			}
		});
		for(ListNode node:lists){
			if(node != null)
				heap.offer(node);
		}
		ListNode head = new ListNode(0);
		ListNode prev = head;
		while (heap.size()>0){
			ListNode current = heap.poll();
			prev.next = current;
			if (current.next != null)
				heap.offer(current.next);
			prev = prev.next;
		}
		return head.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0 || lists == null)
            return null;
        return sortList(lists,0,lists.size()-1);
    }
	public ListNode sortList(ArrayList<ListNode> lists, int left, int right){
		if(left < right){
			int mid = (left+right)/2;
			return merge(sortList(lists,left,mid),sortList(lists,mid+1,right));
		}
		return lists.get(left);
	}
	public ListNode merge(ListNode l1,ListNode l2){
		ListNode dummy = new ListNode(0);
		dummy.next = l1;
		ListNode current = dummy;
		while (l1 != null && l2 != null){
			if (l1.val < l2.val){
				l1 = l1.next;
			}
			else{
				ListNode next = l2.next;
				current.next = l2;
				l2.next = l1;
				l2 = next;
			}
			current = current.next;
		}
		if (l2 != null)
			current.next = l2;
		return dummy.next;
	}
}