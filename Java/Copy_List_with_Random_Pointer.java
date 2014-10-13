class Copy_List_with_Random_Pointer{
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        	return null;
        RandomListNode p = head;
        while(p != null){
        	RandomListNode node = new RandomListNode(p.label);
        	node.next = p.next;
        	p.next = node;
        	p = node.next;
        }
        p = head;
        while(p != null){
        	if(p.random != null){
        		p.next.random = p.random.next;
        	}
        	else{
        		p.next.random = null;
        	}
        	p = p.next.next;
        }
        RandomListNode newHead = head.next;
        p = head;
        while(p != null){
        	RandomListNode dup = p.next;
        	p.next = dup.next;
        	if(dup.next != null)
        		dup.next = dup.next.next;
        	else
        		dup.next = null;
        	p = p.next;
        }
        return newHead;
    }	
}