class Partition List{
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null)
    		return head;
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode pre = dummy;
    	ListNode curr = head;
    	while(curr!= null){
    	    if(curr.val >= x)
    	        break;
    		curr = curr.next;
    		pre = pre.next;
    	}
    	while(curr != null && curr.next != null){
    		if(curr.next.val < x){
    			ListNode temp = curr.next.next;
    			curr.next.next = pre.next;
    			pre.next = curr.next;
    			curr.next = temp;
    			pre = pre.next;
    		}
    		else
    			curr = curr.next;
    	}
    	return dummy.next;
	}
}