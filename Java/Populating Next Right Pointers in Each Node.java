class Populating Next Right Pointers in Each Node{
	public void connect(TreeLinkNode root) {
        iterative(root);
    }
    private void recursive(TreeLinkNode root){
    	if(root == null)
    		return;
    	if(root.left != null){
    		root.left.next = root.right;
    	}
    	TreeLinkNode p = root.next;
    	if(root.right != null){
    		root.right.next = p==null?null:p.left;
    	}
    	recursive(root.left);
    	recursive(root.right);

    }
    private void iterative(TreeLinkNode root){
    	if(root == null)
    		return;
    	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	queue.offer(root);
    	queue.offer(null);
    	while(queue.size()>1){
    		root = queue.poll();
    		if(root == null){
    			queue.offer(null);
    			continue;
    		}
    		root.next = queue.peek();
    		if(root.left != null)
    			queue.offer(root.left);
    		if(root.right != null)
    			queue.offer(root.right);
    	}

    }
}