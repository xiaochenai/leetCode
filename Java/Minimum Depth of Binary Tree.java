class Minimum Depth of Binary Tree{
	//traversal level by level
	//there are solutions do not use extra space
	public int minDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	int currDep = 1;
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
    		for(int i=0;i<size;i++){
    			nodes.add(queue.poll());
    		}
    		for(TreeNode t:nodes){
    			if(t.left == null && t.right == null)
    				return currDep;
    			if(t.left != null)
    				queue.offer(t.left);
    			if(t.right != null)
    				queue.offer(t.right);
    		}
    		currDep++;
    	}
    	return currDep;
    }
}