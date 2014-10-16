class Remove Duplicates from Sorted List II{
	public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while(curr != null && curr.next != null){
        	if(curr.val != curr.next.val){
        		curr=curr.next;
        		pre = pre.next;
        	}
        	else{
        		while(curr.next != null && curr.val == curr.next.val){
        			curr.next = curr.next.next;
        		}
        		pre.next = curr.next;
        		curr = pre.next;
        	}
        }
        return dummy.next;
    }
} 