class Reorder_List{
public void reorderList(ListNode head) {
    	if(head == null || head.next == null)
    		return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        	if(fast.next == null)
        		break;
        	else
        	    fast = fast.next;
        }
        ListNode shalfHead = slow.next;
        slow.next = null;
        ListNode fhalfHead = head;
        ListNode curr = shalfHead;
        ListNode pre = null;
        while(curr != null){
        	ListNode temp = curr.next;
        	curr.next = pre;
        	pre = curr;
        	curr = temp;
        }
        shalfHead = pre;
        while(shalfHead != null){
        	ListNode temp = fhalfHead.next;
        	fhalfHead.next = shalfHead;
        	shalfHead = shalfHead.next;
        	fhalfHead.next.next = temp;
        	fhalfHead = temp;
        }
    }	
}