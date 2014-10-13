class Linked_List_Cycle_II{
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(fast == slow)
        		break;
        }
        if(fast != slow)
        	return null;
        ListNode p = head;
        while(p != slow){
        	p = p.next;
        	slow = slow.next;
        }
        return p;
    }
}