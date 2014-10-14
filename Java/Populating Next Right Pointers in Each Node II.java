class Populating Next Right Pointers in Each Node II{
	public void connect(TreeLinkNode root) {
        iterative(root);
    }
    private void recursive(TreeLinkNode root){
    	if(root == null)
    		return;
    	if(root.left != null){
    		if(root.right != null){
    			root.left.next = root.right;
    		}
    		else{
    			TreeLinkNode p = root.next;
    			while(p != null && p.left == null && p.right == null){
    				p = p.next;
    			}
    			if(p != null){
    				root.left.next = p.left == null?p.right:p.left;
    			}
    			else
    				root.left.next = p;
    		}
    	}
    	if(root.right != null){
    		TreeLinkNode p = root.next;
    		while(p != null && p.left == null && p.right == null){
    				p = p.next;
    		}
 			if(p != null){
				root.right.next = p.left == null?p.right:p.left;
    		}
			else
				root.right.next = p;   		
    	}
    	recursive(root.right);      
        recursive(root.left); 
    }
    private void iterative(TreeLinkNode root){
    	if(root == null)
    		return;
    	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	queue.offer(root);
    	queue.offer(null);
    	while(queue.size()>1){
    		TreeLinkNode temp = queue.poll();
    		if(temp == null){
    			queue.offer(null);
    			continue;
    		}
    		temp.next = queue.peek();
    		if(temp.left != null)
    			queue.offer(temp.left);
    		if(temp.right != null)
    			queue.offer(temp.right);
    	}
    }
}