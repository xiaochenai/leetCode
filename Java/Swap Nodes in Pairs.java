class Swap Nodes in Pairs{
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = head.next;
        ListNode p = head;
        while(end != null){
        	p.next = end.next;
        	pre.next = end;
        	end.next = p;
        	pre = p;
        	p = p.next;
        	if(p == null)
        		return dummy.next;
        	end = p.next;
        }
        return dummy.next;

    }
}