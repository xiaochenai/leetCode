class Sort_List{
	public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode p1 = head;
    	ListNode p2 = head;
    	while(p2.next != null && p2.next.next != null){
    		p1 = p1.next;
    		p2 = p2.next.next;
    	}
    	ListNode head2 = p1.next;
    	p1.next = null;
    	ListNode head1 = head;
    	head1 = mergeSort(head1);
    	head2 = mergeSort(head2);
    	return mergeList(head1,head2);
    }
    private ListNode mergeList(ListNode head1, ListNode head2){
    	if(head1 == null)
    		return head2;
    	if(head2 == null)
    		return head1;
    	ListNode newHead = new ListNode(-1);
    	ListNode p = newHead;
    	while(head1 != null && head2 != null){
    		if(head1.val <= head2.val){
    			p.next = head1;
    			head1 = head1.next;
    			p = p.next;
    		}
    		else{
    			p.next = head2;
    			head2 = head2.next;
    			p = p.next;
    		}	
    	}
    	if(head1 == null)
    		p.next = head2;
    	if(head2 == null)
    		p.next = head1;
    	return newHead.next;
    }
} 	