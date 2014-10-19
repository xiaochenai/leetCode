class Add Two Numbers{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;
        int value = 0;
        int carry = 0;
        ListNode head = l1;
        while(l1.next != null && l2.next != null){
        	value = (carry+l1.val+l2.val)%10;
        	carry = (carry+l1.val+l2.val)/10;
        	l1.val = value;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        if(l1.next == null){
        	l1.next = l2.next;
        }
        l1.val = l1.val+l2.val;
        while(l1.next != null){
        	value = (carry+l1.val)%10;
        	carry = (carry+l1.val)/10;
        	l1.val = value;
        	l1 = l1.next;
        }
        value = (carry+l1.val)%10;
        carry = (carry+l1.val)/10;
        l1.val = value;
        if(carry == 1){
        	l1.next = new ListNode(1);
        }
        return head;
    }
}