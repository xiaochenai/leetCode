class Remove Duplicates from Sorted List{
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode dummy = ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while(curr != null && curr.next != null){
        	if(curr.val != curr.next.val){
        		curr = curr.next;
        		pre = pre.val;
        		continue;
        	}
        	curr.next = curr.next.next;
        }
        return dummy.next;
    }
}