class Convert Sorted List to Binary Search Tree{
	private ListNode currentNode;
	public TreeNode sortedListToBST(ListNode head) {
        
    }
    private TreeNode naive(ListNode head){
    	if(head == null)
    		return null;
    	ListNode c1 = head;
    	ListNode c2 = head;
    	ListNode c3 = ListNode(0);
    	c3.next = head;
    	while(c2 != null && c2.next != null){
    		c2 = c2.next;
    		c1 = c1.next;
    		c3 = c3.next;
    	}
    	TreeNode root = new TreeNode(c1.val);
    	root.right = naive(c1.next);
    	c3.next = null;
    	if(c1 == head)
    		head = null;
    	root.left = sortedListToBST(head);
        return root;
    }
    //reconsruct from the head of list
    private TreeNode expert(ListNode head){
    	int len = 0;
        this.currentNode = head;
        ListNode p = head;
        while(p != null){
            p = p.next;
            len++;
        }
        return constructBST(0,len-1);
    }
    private TreeNode constructBST(int begin, int end){
        if (begin > end)
            return null;
        int mid = (begin + end) / 2;
        TreeNode left = this.constructBST(begin,mid-1);
        TreeNode parent = new TreeNode(this.currentNode.val);
        parent.left = left;
        this.currentNode = this.currentNode.next;
        TreeNode  right = this.constructBST(mid+1,end);
        parent.right = right;
        return parent;
    }
}