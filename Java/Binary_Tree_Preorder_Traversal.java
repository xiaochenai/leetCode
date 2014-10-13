class Binary_Tree_Preorder_Traversal{
	public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        iterative(res,root);
        return res;
    }
	private void iterative(ArrayList<Integer> res, TreeNode root){
    	if(root == null)
    		return;
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		res.add(node.val);
    		if(node.right != null)
    			stack.push(node.right);
    		if(node.left != null)
    			stack.push(node.left);
    	}
    }
}