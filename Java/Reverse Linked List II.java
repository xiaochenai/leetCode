class Reverse Linked List II{
   	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        head = dummy;
        int i=1;
        while(i<m){
        	head = head.next;
        	p = p.next;
        	i++;
        }
        while(i<n){
        	p = p.next;
        	i++;
        }
        ListNode end = p.next;
        ListNode pre = end;
        p = head.next;
        while(p != end){
        	ListNode next = p.next;
        	p.next = pre;
        	pre = p;
        	p = next;
        }
        head.next = pre;
        return dummy.next;
    }
}