class Rotate List{
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n == 0)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = head;
		int len = 1;
		while(p.next != null){
			p=p.next;
			len++;
		}
		int step = len - (n%len);
		p.next = head;
        p = head;
		while(step > 1){
			p = p.next;
			step--;
		}
		dummy.next = p.next;
		p.next = null;
		return dummy.next;

	}
}