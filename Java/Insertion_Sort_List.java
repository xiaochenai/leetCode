class Insertion_Sort_List{
 	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr != null){
        	if(curr.val >= prev.val){
        		prev = curr;
        		curr = curr.next;
        		continue;
        	}
        	ListNode p = dummy;
        	ListNode temp = curr.next;
        	while(p != prev){
        		if(p.val <=curr.val && p.next.val >= curr.val){
        			curr.next = p.next;
        			p.next = curr;
        			curr = temp;
        			prev.next = temp;
        			break;
        		}
        		p = p.next;
        	}
        }
        return dummy.next;
    }
}