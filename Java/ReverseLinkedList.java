public class ReverseLinkedList{
	//head->n1->n2->n3->n4->end
	//reverse node between head and end(n1,n2,n3,n4)
	//this is a general solution, can reverse a whole list with a dummy head
	public void Method1(ListNode head,ListNode end){
		ListNode curr = head.next;//curr = head then reverse list from head that is n4->n3->n2->n1->head->end
		ListNode pre = end;		  //at this time the reverse list will be head->n4->n3->n2->n1->end
		while(curr != end){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		head.next = pre;
		return prev;
	}
	public void Method2(ListNode head,ListNode end){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		Method1(dummy,end);
		return dummy.next;
	}
	public static void main(String[] args){

		System.out.println("aaaa");
	}

}
class ListNode{
	public int value;
	public ListNode next = null;
	public ListNode(int val){
		this.value = val;
	}
}