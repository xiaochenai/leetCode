class Merge k Sorted Lists{
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
       if(lists == null || lists.size() == 0)
            return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
        	public int compare(ListNode n1,ListNode n2){
        		return n1.val - n2.val;
        	}
        });
        for(ListNode node:lists){
        	if(node != null)
        		minHeap.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!minHeap.isEmpty()){
        	ListNode temp = minHeap.poll();
        	if(temp.next != null)
        		minHeap.offer(temp.next);
        	p.next = temp;
        	p = p.next;
        }
        return dummy.next;
    }
}