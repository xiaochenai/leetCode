class Binary_Tree_Postorder_Traversal{
	public List<Integer> postorderTraversal(TreeNode root) {

	}
	private void recursive(ArrayList<Integer> res, TreeNode root){
		if(root == null)
			return;
		if(root.left != null)
			recursive(root.left);
		if(root.right != null)
			recursive(root.right);
		res.add(root.val);
		return;
	}
	private void iterative(ArrayList<Integer> res, TreeNode root){
		if(root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<Integer>();
		TreeNode lastVisited = null;
		while(!stack.isEmpty()||root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}
			else{
				TreeNode temp = stack.peek();
				if(temp.right != null && temp.right != lastVisited){
					root = temp.right;
				}
				else{
					res.add(temp.val);
					stack.pop();
					lastVisited = temp;
				}
			}
		}
	}
}