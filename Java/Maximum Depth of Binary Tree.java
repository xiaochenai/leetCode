class Maximum Depth of Binary Tree{
	public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        int dep = 1;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        	for(int i=0;i<size;i++){
        		temp.add(queue.poll());
        	}
        	for(TreeNode t: temp){
        		if(t.left != null)
        			queue.offer(t.left);
        		if(t.right != null)
        			queue.offer(t.right);
        	}
        	if(queue.size() != 0)
        		dep++;
        }
        return dep;
    }
}