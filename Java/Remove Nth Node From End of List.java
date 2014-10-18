class Remove Nth Node From End of List{
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(hea == null || n==0)
        	return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(n > 0){
        	p1 = p1.next;
            n--;
        }
        if(p1 == null)
            return head.next;
        while(p1.next != null){
        	p1 = p1.next;
        	p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }
}