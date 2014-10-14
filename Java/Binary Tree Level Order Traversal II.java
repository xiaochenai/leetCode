class Binary Tree Level Order Traversal II{
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
        	for(int i=0;i<size;i++){
        		temp.add(queue.poll());
        	}
        	ArrayList<Integer> sol = new ArrayList<Integer>();
        	for(TreeNode t:temp){
        		sol.add(t.val);
        		if(t.left != null)
        			queue.offer(t.left);
        		if(t.right != null)
        			queue.offer(t.right);
        	}
        	res.add(sol);
        }
        Collections.reverse(res);
        return res;
    }
}