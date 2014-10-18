class Reverse Nodes in k-Group{
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
        	return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = head;
        int count = 0;
        while(end != null){
        	while(count < k && end != null){
        		end = end.next;
        		count++;
        	}
        	if(count == k){
        		count = 0;
        		reverse(pre,end);
        		while(count < k){
        			pre = pre.next;
        			count++;
        		}
        		count = 0;
        	}
        	else{
        		if(end == null)
        			return dummy.next;
        	}
        }
        return dummy.next;
    }
    private void reverse(ListNode pre, ListNode end){
    	ListNode curr = pre.next;
    	ListNode p = end;
    	while(curr != end){
    		ListNode temp = curr.next;
    		curr.next = p;
    		p = curr;
    		curr = temp;
    	}
    	pre.next = p;
    }
}