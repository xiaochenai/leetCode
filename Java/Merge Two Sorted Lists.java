class Merge Two Sorted Lists{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode pre = dummy;
        while(h1 != null && h2 != null){
        	if(h1.val <= h2.val){
        		h1 = h1.next;
        	}
        	else{
        		ListNode temp = h2.next;
        		pre.next = h2;
        		h2.next = h1;
        		h2 = temp;
        		pre = pre.next;
        	}
        }
        if(h2 != null)
        	pre.next = h2;
        return dummy.next;
    }
}